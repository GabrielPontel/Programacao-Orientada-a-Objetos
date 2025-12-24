
package visao;

import controledao.ControleAluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import modelo.exceptions.NotExistException;


public class ManutencaoAluno extends javax.swing.JFrame {

    private ControleAluno controle = new ControleAluno();
    private List<Aluno> lista = new ArrayList<>();

    public ManutencaoAluno() {
        initComponents();

        try {
            lista = controle.getTodosAlunos();
            atualizar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no SQL");
        }
    }

    private void atualizar() {
        //Fez o casting lembrar do getModel
        DefaultTableModel modelo = (DefaultTableModel) tabAlunos.getModel();

        // zera a quantidade de linhas
        modelo.setRowCount(0);

        for (Aluno a : lista) {
            modelo.addRow(new Object[]{a.getPront(),
                a.getNome(),
                a.getAnoIngresso(),
                a.getSiglaCurso()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAlunos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botIncluir = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botVisualizar = new javax.swing.JButton();
        Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manutenção Alunos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Prontuário", "Nome", "Ano Ingresso", "Sigla Curso"
            }
        ));
        jScrollPane1.setViewportView(tabAlunos);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        botIncluir.setText("Incluir");
        botIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(botIncluir);

        botAlterar.setText("Alterar");
        botAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(botAlterar);

        botExcluir.setText("Excluir");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(botExcluir);

        botVisualizar.setText("Visualizar");
        botVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVisualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botVisualizar);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        jPanel2.add(Sair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIncluirActionPerformed
        DadosAluno tela = new DadosAluno(this, true);
        tela.setVisible(true);
        try {
            Aluno a = tela.getAluno();
            if (tela.getSalvo()) {
                controle.incluir(a);
                lista = controle.getTodosAlunos();
                atualizar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro com o SQL");
        } catch (NotExistException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_botIncluirActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarActionPerformed
        int linha = tabAlunos.getSelectedRow();

        if (linha != -1) {
            DadosAluno tela = new DadosAluno(this, true);
            tela.setAluno(lista.get(linha));
            tela.setVisible(true);
            if (tela.getSalvo()) {
                Aluno a = tela.getAluno();
                try {
                    controle.alterar(a);
                    lista = controle.getTodosAlunos();
                    atualizar();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Erro no sql");
                } catch (NotExistException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_botAlterarActionPerformed

    private void botVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVisualizarActionPerformed
        int linha = tabAlunos.getSelectedRow();
        
        if(linha != -1){
            Aluno a;
            DadosAluno tela = new DadosAluno(this, true);
            try {
                a = controle.pesquisa(lista.get(linha).getPront());
                tela.setAluno(a);
                tela.setVisible(true);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro no SQL");
            } catch (NotExistException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_botVisualizarActionPerformed

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirActionPerformed
        int linha = tabAlunos.getSelectedRow();
        if(linha != -1){
            try {
                controle.excluir(lista.get(linha).getPront());
                lista = controle.getTodosAlunos(); 
                atualizar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro no SQL");
            } catch (NotExistException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_botExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManutencaoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sair;
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botIncluir;
    private javax.swing.JButton botVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabAlunos;
    // End of variables declaration//GEN-END:variables
}
