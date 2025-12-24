/*
    Gabriel Pontel de Mori - 2025

Projeto introduzindo a utilização da interface swing
*/
import javax.swing.JOptionPane;

public class FramePrincipal extends javax.swing.JFrame {

    
    public FramePrincipal() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtProntuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        botLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtProva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTrabalho = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMedia = new javax.swing.JTextField();
        botCalcular = new javax.swing.JButton();
        botVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Alunos");

        jLabel2.setText("Prontuário");

        txtProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProntuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        botLimpar.setText("Limpar");
        botLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLimparActionPerformed(evt);
            }
        });

        jLabel3.setText("Prova");

        jLabel4.setText("Trabalho");

        jLabel5.setText("Média");

        botCalcular.setText("Calcular Média");
        botCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCalcularActionPerformed(evt);
            }
        });

        botVisualizar.setText("Visualizar Dados");
        botVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(132, 132, 132))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtProva)
                                    .addGap(90, 90, 90)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(92, 92, 92)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(txtMedia)))
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botLimpar)
                    .addComponent(botCalcular)
                    .addComponent(botVisualizar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProntuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProntuarioActionPerformed

    private void botLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimparActionPerformed
        txtProntuario.setText("");
        txtNome.setText("");
        txtProva.setText("");
        txtTrabalho.setText("");
        txtMedia.setText("");
        txtProntuario.requestFocus();
    }//GEN-LAST:event_botLimparActionPerformed

    private void botCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCalcularActionPerformed

        double media = calcularMedia();
        txtMedia.setText(String.valueOf(media));  
        JOptionPane.showMessageDialog(this,determinarSituacao());        
    }//GEN-LAST:event_botCalcularActionPerformed

    private double calcularMedia()
    {
        double nota1, nota2, media=0;
        try {
            nota1 = Double.parseDouble(txtProva.getText());
            nota2 = Double.parseDouble(txtTrabalho.getText());
            media = (nota1+nota2)/2;
        } catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(
                    this, 
                    "Os valores de Prova e Trabalho devem ser numéricos"
            );
        }
        return media;
    }
    
    private String determinarSituacao()
    {
        String situacao = "Reprovado";
        if (calcularMedia() >= 6)
            situacao = "Aprovado";
        return situacao;
    }
    
    private void botVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVisualizarActionPerformed
        DialogDados telaAuxiliar = new DialogDados(this, true);
        
        telaAuxiliar.setDados(
                txtProntuario.getText(),
                txtNome.getText(), 
                calcularMedia(), 
                determinarSituacao()
        );
        
        telaAuxiliar.setVisible(true);
    }//GEN-LAST:event_botVisualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botCalcular;
    private javax.swing.JButton botLimpar;
    private javax.swing.JButton botVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProntuario;
    private javax.swing.JTextField txtProva;
    private javax.swing.JTextField txtTrabalho;
    // End of variables declaration//GEN-END:variables
}
