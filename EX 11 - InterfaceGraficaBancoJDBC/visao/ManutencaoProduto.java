/*
    Gabriel Pontel de Mori - 2025

    Exercicio de Prova
    No qual deveria ser feito um projeto que adiciona-se e altera-se produtos
Etambem poderia da rlances nesses produtos, só poderia excluir itens sem lances e deverias conter a a
funcionalidade de ver os lances de um determinado produto.
*/
package visao;

import controleDAO.ControleProdutoLance;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Lance;

import modelo.Produto;
import modelo.exceptions.NotExistException;
import modelo.exceptions.NotFoundException;

public class ManutencaoProduto extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(s.class.getName());
    private ControleProdutoLance controle = new ControleProdutoLance();
    private List<Produto> listaProd = new ArrayList<>();
    
    public ManutencaoProduto() {
        initComponents();
        try{
            listaProd = controle.getTodosProdutos();
            atualizarTabela();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Erro no SQL");
        }
        
    }

    private void atualizarTabela(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tabProdutos.getModel();
        
        //Limpa a tabela
        modelo.setRowCount(0);
        
        for(Produto p:listaProd){
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getValorAtual(),
                p.getDescricao()
            });
        }
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProdutos = new javax.swing.JTable();
        botIncluirProd = new javax.swing.JButton();
        botAlterarProd = new javax.swing.JButton();
        botExcluirProd = new javax.swing.JButton();
        botDarLance = new javax.swing.JButton();
        botVerLances = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manutenção  Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tabProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Valor Atual", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(tabProdutos);

        botIncluirProd.setText("Incluir Produto");
        botIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIncluirProdActionPerformed(evt);
            }
        });

        botAlterarProd.setText("Alterar Produto");
        botAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarProdActionPerformed(evt);
            }
        });

        botExcluirProd.setText("Excluir Produto");
        botExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirProdActionPerformed(evt);
            }
        });

        botDarLance.setText("Dar lance");
        botDarLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDarLanceActionPerformed(evt);
            }
        });

        botVerLances.setText("Ver lances de um Produto");
        botVerLances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVerLancesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botExcluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botDarLance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botVerLances))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botAlterarProd)
                    .addComponent(botIncluirProd)
                    .addComponent(botExcluirProd)
                    .addComponent(botDarLance)
                    .addComponent(botVerLances))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIncluirProdActionPerformed
        DadosProduto tela = new DadosProduto(this, true);
        tela.setVisible(true);
        if(tela.getSalvar()){
            
            try {
                Produto p = tela.getProduto();
                controle.inserirProduto(p);
                listaProd = controle.getTodosProdutos();
                atualizarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro no sql");
            }
        }
    }//GEN-LAST:event_botIncluirProdActionPerformed

    private void botVerLancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVerLancesActionPerformed
        int linha = tabProdutos.getSelectedRow();
        
        if(linha != -1){
            ManutencaoLance tela = new ManutencaoLance();
            tela.apresentarTabelaLances(listaProd.get(linha).getCodigo());
            tela.setVisible(true);
        }
    }//GEN-LAST:event_botVerLancesActionPerformed

    private void botAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarProdActionPerformed
        int linha = tabProdutos.getSelectedRow();
        
        if(linha != -1){
            DadosProduto tela = new DadosProduto(this, true);
            tela.setProduto(listaProd.get(linha));
            tela.setVisible(true);
            if(tela.getSalvar()){
                try{
                    Produto p = tela.getProduto();
                    controle.alterarProduto(p);
                    listaProd = controle.getTodosProdutos();
                    atualizarTabela();
                }catch(NotExistException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Erro no sql");
                }
            }
        }
    }//GEN-LAST:event_botAlterarProdActionPerformed

    private void botExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirProdActionPerformed
        int linha = tabProdutos.getSelectedRow();
        
        if(linha != -1){
            
            try{
                Produto p = listaProd.get(linha);
                controle.excluirProduto(p.getCodigo());
                listaProd = controle.getTodosProdutos();
                atualizarTabela();
            }catch(NotExistException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Erro no sql");
            }catch(NotFoundException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            
        }
    }//GEN-LAST:event_botExcluirProdActionPerformed

    private void botDarLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDarLanceActionPerformed
        int linha = tabProdutos.getSelectedRow();
        
        if(linha != -1){
            
            DadosLance tela = new DadosLance(this, true);
            tela.setCodigo(listaProd.get(linha).getCodigo());
            tela.setVisible(true);
            if(tela.getConfirma()){
                try{
                    Lance l = tela.getLance();
                    l.setCodigoProduto(listaProd.get(linha).getCodigo());
                    controle.darLance(l);
                    listaProd = controle.getTodosProdutos();
                    atualizarTabela();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Erro no sql");
                }catch(NotExistException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_botDarLanceActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ManutencaoProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterarProd;
    private javax.swing.JButton botDarLance;
    private javax.swing.JButton botExcluirProd;
    private javax.swing.JButton botIncluirProd;
    private javax.swing.JButton botVerLances;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabProdutos;
    // End of variables declaration//GEN-END:variables
}
