package view;

import dao.SQLiteJBDC;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

public class Inicio extends javax.swing.JFrame {

    //variaveis para o banco
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Inicio() {
        
        initComponents();
        conn = SQLiteJBDC.conexaodb();
        
        colocaTableHj();
        colocaTableAntes();
        colocaTableDepois();
        
    }
    
    public void colocaTableHj() {
        
        DefaultTableModel model = (DefaultTableModel) jTableHoje.getModel();
        model.setNumRows(0);
        
        DateFormat df = new SimpleDateFormat("dd/MM");
        
        Calendar gc = Calendar.getInstance();
        
        String datahoje = df.format(gc.getTime());
        
        for (Cliente c : leituraLike(datahoje, datahoje)) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getApelido(),
                c.getRg(),
                c.getNasc()
            });
        }
    }
    
    public void colocaTableAntes() {
        
        DefaultTableModel model = (DefaultTableModel) jTableAntes.getModel();
        model.setNumRows(0);
        
        DateFormat df = new SimpleDateFormat("dd/MM");
        
        Calendar gc = Calendar.getInstance();
        
        gc.add((GregorianCalendar.DAY_OF_MONTH), 1);        
        
        String dataantes = df.format(gc.getTime());
        
        gc.add((GregorianCalendar.DAY_OF_MONTH), 1);        
        
        String dataantes2 = df.format(gc.getTime());
        
        //System.out.println("data :" + dataantes);
        
        for (Cliente c : leituraLike(dataantes, dataantes2)) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getApelido(),
                c.getRg(),
                c.getNasc()
            });
        }
    }
    
    public void colocaTableDepois() {
        
        DefaultTableModel model = (DefaultTableModel) jTableDepois.getModel();
        model.setNumRows(0);
        
        DateFormat df = new SimpleDateFormat("dd/MM");
        
        Calendar gc = Calendar.getInstance();
        
        gc.add((GregorianCalendar.DAY_OF_MONTH), -1);        
        
        String datadepois = df.format(gc.getTime());
        
        gc.add((GregorianCalendar.DAY_OF_MONTH), -1);        
        
        String datadepois2 = df.format(gc.getTime());
        
        //System.out.println("data :" + datadepois);
        
        for (Cliente c : leituraLike(datadepois, datadepois2)) {
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getApelido(),
                c.getRg(),
                c.getNasc()
            });
        }
    }
    
    public List<Cliente> leituraLike(String data, String data2) {
        
        List<Cliente> clientes = new ArrayList<>();
        
        String sql = "SELECT * FROM clientes where nasc LIKE '" + data + "%' OR nasc LIKE '" + data2 + "%' order by nome";
        
        try {
            pst = conn.prepareStatement(sql);
            
            System.out.println("print: " + pst);
            
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
            System.out.println(e);
            System.out.println("parte de colocar dados na lista");
            JOptionPane.showMessageDialog(null, e);
        }
        
        return clientes;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAntes = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHoje = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDepois = new javax.swing.JTable();
        atualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADV-ANIV 1.0");
        setResizable(false);

        jButton1.setText("Cadastrar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("ADV-ANIV 1.0");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 148, 1));
        jLabel2.setText("Clientes Aniversariando Hoje:");

        jTableAntes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane1.setViewportView(jTableAntes);

        label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(176, 166, 22));
        label1.setText("Clientes que irão aniversariar nos próximos 2 dias:");

        jTableHoje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane3.setViewportView(jTableHoje);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(218, 0, 0));
        jLabel3.setText("Clientes que aniversariaram nos últimos 2 dias:");

        jTableDepois.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane2.setViewportView(jTableDepois);

        atualizar.setText("Atualizar Dados");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Desenvolvido por:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Flávio Salgado");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setText("Engenheiro da Computação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 392, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(352, 352, 352))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(206, 206, 206))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(atualizar)
                                .addGap(389, 389, 389))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(120, 120, 120)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(471, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setVisible(true);
        cadastroCliente.setEnabled(true);

        //evita fechamento de toda a aplicacao
        cadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        colocaTableHj();
        colocaTableAntes();
        colocaTableDepois();
    }//GEN-LAST:event_atualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAntes;
    private javax.swing.JTable jTableDepois;
    private javax.swing.JTable jTableHoje;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
