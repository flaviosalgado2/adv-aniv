package view;

import dao.SQLiteJBDC;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

public class CadastroCliente extends javax.swing.JFrame {

    //variaveis para o banco
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CadastroCliente() {

        initComponents();
        conn = SQLiteJBDC.conexaodb();

        //carregando dados na tabela
        leituraJTable();
        nClientes();
    }

    public void leituraJTable() {

        DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
        model.setNumRows(0);
        for (Cliente c : leitura()) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getApelido(),
                c.getRg(),
                c.getNasc()
            });
        }
    }

    public List<Cliente> leitura() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY nome";

        try {
            pst = conn.prepareStatement(sql);

            //System.out.println("print: " + pst);
            rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setApelido(rs.getString("apelido"));
                cliente.setRg(rs.getString("rg"));
                cliente.setNasc(rs.getString("nasc"));

                clientes.add(cliente);
            }

            //JOptionPane.showMessageDialog(null, "Dados de Clientes Carregado com Sucesso!");
        } catch (Exception e) {
            //System.out.println(e);
            //System.out.println("parte de colocar dados na lista");
            JOptionPane.showMessageDialog(null, e);
        }

        return clientes;

    }

    public void nClientes() {

        String sql = "select count(id) from clientes";
        String retorno = "";

        try {
            pst = conn.prepareStatement(sql);

            //System.out.println("print: " + pst);
            rs = pst.executeQuery();

            retorno = rs.getString("count(id)");
            
            //colocando quantidade de clientes no label
            jLabelnClientes.setText(retorno);

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoApelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        campoNasc = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        campoId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoRg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelnClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadatro de Cliente - ADV-ANIV 1.0");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Cliente");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Cliente");

        jLabel3.setText("Apelido");

        campoApelido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApelidoActionPerformed(evt);
            }
        });

        jLabel4.setText("RG");

        jLabel5.setText("Data de Nascimento");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(77, 238, 74));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Apelido", "RG", "Data de Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        tabelaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaClientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        try {
            campoNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNascActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(253, 58, 18));
        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jButton3.setText("Excluir Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        campoId.setEnabled(false);
        campoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        campoRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRgKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoRgKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(13, 1, 147));
        jLabel7.setText("Quantidade de Clientes Cadastrados:");

        jLabelnClientes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(campoId, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(campoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(campoNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabelnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoNasc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoApelidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApelidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApelidoActionPerformed

    private void campoNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNascActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (campoId.getText() == null || campoId.getText().isEmpty()) {

            String sql = "INSERT INTO clientes(nome, apelido, rg, nasc) VALUES (?,?,?,?)";

            try {
                pst = conn.prepareStatement(sql);

                System.out.println("print: " + pst);

                pst.setString(1, campoNome.getText());
                pst.setString(2, campoApelido.getText());
                pst.setString(3, campoRg.getText());
                pst.setString(4, campoNasc.getText());

                System.out.println("Nosso Sql: " + campoRg.getText());

                pst.execute();

                JOptionPane.showMessageDialog(null, "Cliente Inserido com Sucesso no Banco de Dados");

                campoId.setText("");
                campoNome.setText("");
                campoApelido.setText("");
                campoRg.setText("");
                campoNasc.setText("");

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }
        } else {

            String id = campoId.getText();

            String sql = "UPDATE clientes SET nome = ?, apelido = ?, rg = ?, nasc = ? WHERE id = " + id;

            try {

                pst = conn.prepareStatement(sql);

                pst.setString(1, campoNome.getText());
                pst.setString(2, campoApelido.getText());
                pst.setString(3, campoRg.getText());
                pst.setString(4, campoNasc.getText());

                System.out.println("valor do campo : " + campoRg.getText().length());

                pst.execute();

                JOptionPane.showMessageDialog(null, "Cliente Editado com Sucesso no Banco de Dados");

                campoId.setText("");
                campoNome.setText("");
                campoApelido.setText("");
                campoRg.setText("");
                campoNasc.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        //carregando dados na tabela
        leituraJTable();
        nClientes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked

        int linha = tabelaClientes.getSelectedRow();

        campoId.setText(tabelaClientes.getValueAt(linha, 0).toString());
        campoNome.setText(tabelaClientes.getValueAt(linha, 1).toString());
        campoApelido.setText(tabelaClientes.getValueAt(linha, 2).toString());
        campoRg.setText(tabelaClientes.getValueAt(linha, 3).toString());
        campoNasc.setText(tabelaClientes.getValueAt(linha, 4).toString());

    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        campoId.setText("");
        campoNome.setText("");
        campoApelido.setText("");
        campoRg.setText("");
        campoNasc.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String id = campoId.getText();
        String sql = "DELETE FROM clientes WHERE id = '" + id + "'";

        try {
            pst = conn.prepareStatement(sql);

            pst.execute();

            JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso no Banco de Dados");

            campoId.setText("");
            campoNome.setText("");
            campoApelido.setText("");
            campoRg.setText("");
            campoNasc.setText("");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }

        //carregando dados na tabela
        leituraJTable();
        nClientes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoRgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRgKeyPressed

    }//GEN-LAST:event_campoRgKeyPressed

    private void campoRgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRgKeyTyped


    }//GEN-LAST:event_campoRgKeyTyped

    private void tabelaClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaClientesKeyPressed


    }//GEN-LAST:event_tabelaClientesKeyPressed

    private void tabelaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaClientesKeyReleased

        int linha = tabelaClientes.getSelectedRow();

        campoId.setText(tabelaClientes.getValueAt(linha, 0).toString());
        campoNome.setText(tabelaClientes.getValueAt(linha, 1).toString());
        campoApelido.setText(tabelaClientes.getValueAt(linha, 2).toString());
        campoRg.setText(tabelaClientes.getValueAt(linha, 3).toString());
        campoNasc.setText(tabelaClientes.getValueAt(linha, 4).toString());
    }//GEN-LAST:event_tabelaClientesKeyReleased

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoApelido;
    private javax.swing.JTextField campoId;
    private javax.swing.JFormattedTextField campoNasc;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoRg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelnClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
