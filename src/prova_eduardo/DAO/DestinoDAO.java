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
import prova_eduardo.Classes.Destino;
import prova_eduardo.jdbc.ConnectionFactory;

/**
 *
 * @author eduar
 */
public class DestinoDAO implements GenericDAO<Destino> {

    private Connection connection = null;

    @Override
    public void save(Destino entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into Destino (cd_destino, ds_destino")
                    .append(", dt_inicio, dt_termino, vl_total) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDestino());
            pstm.setDate(3, entity.getDataInicial());
            pstm.setDate(4, entity.getDataTermino());
            //new java.sql.Date(Calendar.getInstance().getTimeInMillis())
            pstm.setDouble(5, entity.getValorTotal());
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
    public void update(Destino entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("update into Destino (ds_destino, dt_inicio")
                    .append(", dt_termino, vl_total, cd_destino) values (?,?,?,?,?)");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDestino());
            pstm.setDate(2, (Date) entity.getDataInicial());
            pstm.setDate(3, (Date) entity.getDataTermino());
            pstm.setDouble(4, entity.getValorTotal());
            pstm.setInt(5, entity.getCodigo());
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
            String sql = "delete from destino where cd_destino = " + id;
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
    public Destino getById(int id) throws SQLException {
        Destino destino = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO WHERE CD_DESTINO = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destino = new Destino();
            while (rs.next()) {
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDataInicial(rs.getDate("DT_INICIO"));
                destino.setDataTermino(rs.getDate("DT_TERMINO"));
                destino.setValorTotal(rs.getDouble("VL_TOTAL"));
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Destino pelo ID!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return destino;
    }

    @Override
    public List<Destino> getByName(String name) throws SQLException {
        List<Destino> listaDestinos = null;
        Destino destino = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO WHERE UPPER(DS_DESTINO) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaDestinos = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDataInicial(rs.getDate("DT_INICIO"));
                destino.setDataTermino(rs.getDate("DT_TERMINO"));
                destino.setValorTotal(rs.getDouble("VL_TOTAL"));
                listaDestinos.add(destino);
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Destino(s)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaDestinos;
    }

    @Override
    public List<Destino> getAll() throws SQLException {
        List<Destino> listaDestinos = null;
        Destino destino = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO ORDER BY CD_DESTINO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaDestinos = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDataInicial(rs.getDate("DT_INICIO"));
                destino.setDataTermino(rs.getDate("DT_TERMINO"));
                destino.setValorTotal(rs.getDouble("VL_TOTAL"));
                listaDestinos.add(destino);
            }
            pstm.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Destino(s)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaDestinos;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_DESTINO),0)+1 AS MAIOR FROM DESTINO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao pegar maior ID Destino");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

}
