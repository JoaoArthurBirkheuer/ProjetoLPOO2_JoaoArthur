/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;

import com.mycompany.projetolpooe2_joaoarthur.model.Funcionario;
import com.mycompany.projetolpooe2_joaoarthur.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class EdicaoCadastroFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form EdicaoCadastroFuncionario
     */
    private Long idPessoa;
    private JFrame parent;
    
    public EdicaoCadastroFuncionario(JFrame parent, Long idPessoa) {
        this.parent = parent;
        this.idPessoa = idPessoa;
        initComponents();
        carregarDadosFuncionario();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void carregarDadosFuncionario() {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur").createEntityManager();
            Funcionario funcionario = em.find(Funcionario.class, idPessoa);

            if (funcionario != null) {
                jTextField1.setText(funcionario.getNome());
                jTextField2.setText(funcionario.getCpf());
                jTextField3.setText(funcionario.getEmail());
                jTextField4.setText(funcionario.getCargo());
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

            Funcionario f = em.find(Funcionario.class, idPessoa);
            if (f != null) {
                f.setNome(jTextField1.getText());
                f.setCpf(jTextField2.getText());
                f.setEmail(jTextField3.getText());
                f.setCargo(jTextField4.getText());
                em.persist(f);
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
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("Edição de Registro de Funcionário");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Email:");

        jLabel5.setText("Cargo:");

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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
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
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(69, 69, 69))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    
    if(jTextField4.getText().trim().isEmpty())
    {
       JOptionPane.showMessageDialog(this, "O campo Cargo não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
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
       Funcionario f = em.find(Funcionario.class, idPessoa);

        if (f == null) {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            em.close();
            return;
        }
        
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Funcionario u WHERE u.cpf = :cpf", Long.class);
        query.setParameter("cpf", jTextField2.getText().trim());
        Long count = query.getSingleResult();

        if (count > 0 && !jTextField2.getText().trim().equals(f.getCpf())) {
            JOptionPane.showMessageDialog(this, "O CPF já está cadastrado!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualizando os dados do usuário
        em.getTransaction().begin();
        f.setNome(jTextField1.getText().trim());
        f.setCpf(jTextField2.getText().trim());
        f.setEmail(jTextField3.getText().trim());
        f.setCargo(jTextField4.getText().trim());
        em.persist(f); // Salva as mudanças
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
        SwingUtilities.invokeLater(() -> new TelaFuncionarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
