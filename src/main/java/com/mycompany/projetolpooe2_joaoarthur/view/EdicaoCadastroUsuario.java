/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;
import javax.persistence.*;
import com.mycompany.projetolpooe2_joaoarthur.dao.*;
import com.mycompany.projetolpooe2_joaoarthur.model.Usuario;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class EdicaoCadastroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form EdicaoCadastroUsuario
     */
    private Long idPessoa;
    private JFrame parent;

    public EdicaoCadastroUsuario(JFrame parent, Long idPessoa) {
        this.parent = parent;
        this.idPessoa = idPessoa;
        initComponents();
        carregarDadosUsuario();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void carregarDadosUsuario() {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur").createEntityManager();
            Usuario usuario = em.find(Usuario.class, idPessoa);

            if (usuario != null) {
                jTextField1.setText(usuario.getNome());
                jTextField2.setText(usuario.getCpf());
                jTextField3.setText(usuario.getEmail());
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
    }
    
    private void atualizarDados() {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur").createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            Usuario usuario = em.find(Usuario.class, idPessoa);
            if (usuario != null) {
                usuario.setNome(jTextField1.getText());
                usuario.setCpf(jTextField2.getText());
                usuario.setEmail(jTextField3.getText());
                em.merge(usuario);
                transaction.commit();
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado para atualização.");
            }
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar dados: " + ex.getMessage());
        } finally {
            if (em != null) em.close();
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Edição de Registro de Usuário");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Email:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Realizar Alterações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextField2.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextField3.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo Email não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!(jTextField2.getText().trim()).matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
        JOptionPane.showMessageDialog(this, "CPF inválido. Por favor, verifique o formato.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Conexão com o banco
        EntityManager em = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur").createEntityManager();

        // Buscar o usuário no banco
        Usuario usuario = em.find(Usuario.class, idPessoa);

        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            em.close();
            return;
        }
        
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.cpf = :cpf", Long.class);
        query.setParameter("cpf", jTextField2.getText().trim());
        Long count = query.getSingleResult();

        if (count > 0 && !jTextField2.getText().trim().equals(usuario.getCpf())) {
            JOptionPane.showMessageDialog(this, "O CPF já está cadastrado!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualizando os dados do usuário
        em.getTransaction().begin();
        usuario.setNome(jTextField1.getText().trim());
        usuario.setCpf(jTextField2.getText().trim());
        usuario.setEmail(jTextField3.getText().trim());
        em.persist(usuario); // Salva as mudanças
        em.getTransaction().commit();
        em.close();

        JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Configurar o look and feel para melhorar o design
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Abrir a tela principal
        SwingUtilities.invokeLater(() -> new TelaUsuarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
