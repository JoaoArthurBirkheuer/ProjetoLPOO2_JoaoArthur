/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;

import com.mycompany.projetolpooe2_joaoarthur.model.*;
import com.mycompany.projetolpooe2_joaoarthur.dao.*;
import com.mycompany.projetolpooe2_joaoarthur.view.EdicaoCadastroUsuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TelaUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form TelaPessoas
     */
    public TelaUsuarios() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PersistenciaJPA jpa = new PersistenciaJPA();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Controle e Pesquisa de usuários");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButton1.setText("Mostrar dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deletar Selecionado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Novo registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar Selecionado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Nome");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("CPF");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Email");
        }

        jLabel2.setText("Pesquisar:");

        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void realizarPesquisa() {
    try {
        String pesquisa = jTextField1.getText().trim();

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
            "postgres", 
            "jb12"
        );

        Statement st = con.createStatement();
        String sql = "SELECT idPessoa, nome, cpf, email FROM tb_usuario WHERE nome ILIKE '%" + pesquisa + "%' OR cpf ILIKE '%" + pesquisa + "%' OR email ILIKE '%" + pesquisa + "%'";
        ResultSet rs = st.executeQuery(sql);

        DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
        tblModel.setRowCount(0);

        while (rs.next()) {
            String id = String.valueOf(rs.getLong("idPessoa"));
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");

            String tbData[] = {id, nome, cpf, email};
            tblModel.addRow(tbData);
        }

        rs.close();
        st.close();
        con.close();
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + ex.getMessage());
    }
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // mostrar dados
        try {
    
        Class.forName("org.postgresql.Driver");

       
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
            "postgres", 
            "jb12"
        );

        Statement st = con.createStatement();
        String sql = "SELECT idPessoa, nome, cpf, email FROM tb_usuario";
        ResultSet rs = st.executeQuery(sql);

 
        DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
        tblModel.setRowCount(0);// tblModel.setRowCount(0); // Limpa os dados anteriores

        while (rs.next()) {
            String id = String.valueOf(rs.getLong("idPessoa"));
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            
            System.out.println("\nACHOU\n");

            String tbData[] = {id, nome, cpf, email};
            tblModel.addRow(tbData);
        }

        rs.close();
        st.close();
        con.close();

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // novo registro
        TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
        telaCadastroUsuario.setVisible(true);
        telaCadastroUsuario.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //editar
        int linhaSelecionada = jTable2.getSelectedRow();

    if (linhaSelecionada == -1) {
    JOptionPane.showMessageDialog(this, "Por favor, selecione um usuário na tabela.");
    return;
    }

    try {
        Long idPessoa = Long.parseLong(jTable2.getValueAt(linhaSelecionada, 0).toString());

        EdicaoCadastroUsuario telaEdicao = new EdicaoCadastroUsuario(this, idPessoa);
        telaEdicao.setVisible(true);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao processar o ID do usuário.");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // deletar
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir!");
        return;
    }
    
        String id = (String) jTable2.getValueAt(selectedRow, 0);
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não é possível excluir registros vazios. Certifique-se de que os dados foram carregados corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


    int confirm = JOptionPane.showConfirmDialog(
        this, 
        "Tem certeza que deseja excluir este registro?", 
        "Confirmação", 
        JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return; // Usuário cancelou
    }

    DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
    Long idUsuario = Long.parseLong(tblModel.getValueAt(selectedRow, 0).toString());

    try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, idUsuario);
        if (usuario != null) {
            List<Avaliacao> avaliacoes = em.createQuery(
                    "SELECT a FROM Avaliacao a WHERE a.usuario.idPessoa = :idUsuario", Avaliacao.class)
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();

            for (Avaliacao avaliacao : avaliacoes) {
                em.remove(avaliacao);
            }

            List<Emprestimo> emprestimos = em.createQuery(
                    "SELECT e FROM Emprestimo e WHERE e.usuario.idPessoa = :idUsuario", Emprestimo.class)
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();

            for (Emprestimo emprestimo : emprestimos) {
                Set<Livro> livrosEmprestados = emprestimo.getLivrosEmprestados();
                if (livrosEmprestados != null) {
                    livrosEmprestados.clear();
                }
                em.remove(emprestimo);
            }

            em.remove(usuario);

            System.out.println("Usuário com ID " + idUsuario + " e seus registros relacionados foram deletados.");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

        JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
        tblModel.removeRow(selectedRow); // Atualiza a tabela
    } catch (Exception ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao excluir registro: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
        // TODO add your handling code here:
        // nao fazer nada aqui
    }//GEN-LAST:event_formHierarchyChanged

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
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
