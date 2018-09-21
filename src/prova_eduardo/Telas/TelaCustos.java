/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo.Telas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prova_eduardo.Classes.Custos;
import prova_eduardo.Classes.Destino;
import prova_eduardo.DAO.CustosDAO;
import prova_eduardo.DAO.DestinoDAO;

/**
 *
 * @author eduar
 */
public class TelaCustos extends javax.swing.JDialog {

    private CustosDAO custosDAO;
    private DestinoDAO destinosDAO;

    public TelaCustos(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        custosDAO = new CustosDAO();
        try {
            carregaTable(custosDAO.getAll());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inicializar carregamento de TABELA");
        }

        inicializar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCodigoDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        btFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CUSTOS");

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");
        jLabel2.setToolTipText("Código da proxima tela a ser criada");

        tfCodigo.setEditable(false);
        tfCodigo.setText("--");

        jLabel3.setText("Código do Destino");

        jLabel4.setText("Descrição");

        jLabel5.setText("Tipo");

        jLabel6.setText("Valor");

        jLabel7.setText("Filtro");

        buttonGroup1.add(rbCodigo);
        rbCodigo.setText("Código");

        buttonGroup1.add(rbDescricao);
        rbDescricao.setText("Descrição");

        tfFiltro.setToolTipText("Pesquisa");

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Destino", "Descrição", "Tipo", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabela);

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodigoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfDescricao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(tfValor)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(rbDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFiltrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNovo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(tfCodigoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCodigo)
                    .addComponent(rbDescricao)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfCodigoDestino.setEditable(true);
        tfDescricao.setEditable(true);
        tfTipo.setEditable(true);
        tfValor.setEditable(true);
        btSalvar.setEnabled(true);
        try {
            ultimoID();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCustos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar();
        tfCodigoDestino.setEditable(false);
        tfDescricao.setEditable(false);
        tfTipo.setEditable(false);
        tfValor.setEditable(false);
        try {
            ultimoID();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCustos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        remover();
        tfCodigoDestino.setEditable(false);
        tfDescricao.setEditable(false);
        tfTipo.setEditable(false);
        tfValor.setEditable(false);
        try {
            ultimoID();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCustos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        filtrar();
    }//GEN-LAST:event_btFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCustos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCustos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCustos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCustos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCustos dialog = null;
                try {
                    dialog = new TelaCustos(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCustos.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoDestino;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfFiltro;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

    private void inicializar() throws SQLException {

        rbCodigo.setSelected(true);

        tfCodigoDestino.setEditable(false);
        tfDescricao.setEditable(false);
        tfTipo.setEditable(false);
        tfValor.setEditable(false);
        ultimoID();
    }

    private void carregaTable(List<Custos> custosList) {
        if (custosList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
        model.setRowCount(0);
        for (Custos c : custosList) {
            model.addRow(new Object[]{c.getCodigo(), c.getCodigoDestino(), c.getDescricao(), c.getTipo(), c.getValor()});
        }
    }

    private void salvar() {
        Custos custo = new Custos();
        custo.setCodigo(Integer.parseInt(tfCodigo.getText()));
        custo.setCodigoDestino(Integer.parseInt(tfCodigoDestino.getText()));
        custo.setDescricao(tfDescricao.getText());
        custo.setTipo(Integer.parseInt(tfTipo.getText()));
        custo.setValor(Double.parseDouble(tfValor.getText()));

        try {
            if (custosDAO.getLastId() == Integer.parseInt(tfCodigo.getText())) {
                custosDAO.save(custo);
                somaCustoDestino(custo.getCodigo(), custo.getCodigoDestino(), custo.getDescricao(), custo.getTipo(), custo.getValor());
            } else {
                custosDAO.update(custo);
            }
            JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso!!!");
            limpaCampos();
            btSalvar.setEnabled(false);
            carregaTable(custosDAO.getAll());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void remover() {
        int codigoRemover = (int) Tabela.getValueAt(Tabela.getSelectedRow(), 0);
        try {
            custosDAO.delete(codigoRemover);
            carregaTable(custosDAO.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void limpaCampos() {
        tfValor.setText("");
        tfCodigoDestino.setText("");
        tfDescricao.setText("");
        tfFiltro.setText("");
        tfTipo.setText("");
    }

    private void filtrar() {
        try {
            if (rbCodigo.isSelected() && tfFiltro.getText().trim().length() != 0) {
                Custos custo = custosDAO.getById(Integer.parseInt(tfFiltro.getText()));
                List<Custos> custosList = new ArrayList<>();
                custosList.add(custo);
                carregaTable(custosList);
            } else if (rbDescricao.isSelected() && tfFiltro.getText().trim().length() != 0) {
                carregaTable(custosDAO.getByName(tfFiltro.getText()));
            } else {
                carregaTable(custosDAO.getAll());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void ultimoID() throws SQLException {
        try {
            tfCodigo.setText(String.valueOf(custosDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void somaCustoDestino(int codigo, int codigoDestino, String descricao, int tipo, double valor) throws SQLException {
        Custos custo = new Custos();
        Destino destino = null;
        destino = destinosDAO.getById(codigoDestino);
        System.out.println(destino.getValorTotal());
        custo.setCodigo(codigo);
        custo.setCodigoDestino(codigoDestino);
        custo.setDescricao(descricao);
        custo.setTipo(tipo);
        custo.setValor(Double.valueOf(valor) + Double.valueOf(destino.getValorTotal()));

        custosDAO.update(custo);
    }

}
