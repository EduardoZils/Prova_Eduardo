/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import prova_eduardo.Classes.Custos;
import prova_eduardo.jdbc.ConnectionFactory;

/**
 *
 * @author eduar
 */
public class CustosDAO implements GenericDAO<Custos> {

    private Connection connection = null;

    @Override
    public void save(Custos entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Custo (cd_custo, cd_destino")
                    .append(", ds_custo, tp_custo, vl_custo) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getCodigoDestino());
            pstm.setString(3, entity.getDescricao());
            pstm.setInt(4, entity.getTipo());
            pstm.setDouble(5, entity.getValor());
            pstm.execute();
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel SALVAR");
            ex.printStackTrace();
        } finally {
            this.connection.close();;
        }
    }

    @Override
    public void update(Custos entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update into Custo (cd_custo, cd_destino")
                    .append(", ds_custo, tp_custo, vl_custo) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getCodigoDestino());
            pstm.setString(3, entity.getDescricao());
            pstm.setInt(4, entity.getTipo());
            pstm.setDouble(5, entity.getValor());
            pstm.execute();
            pstm.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ATUALIZAR");
            ex.printStackTrace();
        } finally {
            this.connection.close();;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from custo where cd_custo = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel DELETAR");
            ex.printStackTrace();
        } finally {
            this.connection.close();;
        }
    }

    @Override
    public Custos getById(int id) throws SQLException {
        Custos custo = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO WHERE CD_CUSTO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custo = new Custos();
            while (rs.next()) {
                custo.setCodigo(rs.getInt("CD_CUSTO"));
                custo.setCodigoDestino(rs.getInt("CD_DESTINO"));
                custo.setDescricao(rs.getString("DS_CUSTO"));
                custo.setTipo(rs.getInt("TP_CUSTO"));
                custo.setValor(rs.getDouble("VL_CUSTO"));
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Custo pelo ID!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return custo;
    }

    @Override
    public List<Custos> getByName(String name) throws SQLException {
        List<Custos> listaCustos = null;
        Custos custo = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO WHERE UPPER(DS_CUSTO) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaCustos = new ArrayList<>();
            while (rs.next()) {
                custo = new Custos();
                custo.setCodigo(rs.getInt("CD_CUSTO"));
                custo.setCodigoDestino(rs.getInt("CD_DESTINO"));
                custo.setDescricao(rs.getString("DS_CUSTO"));
                custo.setTipo(rs.getInt("TP_CUSTO"));
                custo.setValor(rs.getDouble("VL_CUSTO"));
                listaCustos.add(custo);
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Custo(s)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaCustos;
    }

    @Override
    public List<Custos> getAll() throws SQLException {
        List<Custos> listaCustos = null;
        Custos custo = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO ORDER BY CD_CUSTO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaCustos = new ArrayList<>();
            while (rs.next()) {
                custo = new Custos();
                custo.setCodigo(rs.getInt("CD_CUSTO"));
                custo.setCodigoDestino(rs.getInt("CD_DESTINO"));
                custo.setDescricao(rs.getString("DS_CUSTO"));
                custo.setTipo(rs.getInt("TP_CUSTO"));
                custo.setValor(rs.getDouble("VL_CUSTO"));
                listaCustos.add(custo);
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Custo(s)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaCustos;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_CUSTO),0)+1 AS MAIOR FROM CUSTO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao pegar maior ID Custo");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

}
//
