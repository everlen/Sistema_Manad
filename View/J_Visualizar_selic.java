/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.C_Selic;
import Model.Modelo_tabelas.Model_table_selic;
import Model.Selic;
import java.util.ArrayList;

/**
 *
 * @author Victony
 */
public class J_Visualizar_selic extends javax.swing.JFrame {

    Model_table_selic modelo;
    J_Inicial jj_inicial;
    
    public J_Visualizar_selic(J_Inicial j_inicial) {
        initComponents();
        this.setLocationRelativeTo(null);
        jj_inicial = j_inicial;
        Atualizar();
    }

    public void Atualizar(){
        modelo = new Model_table_selic();
        ArrayList<ArrayList<Selic>> matriz_selic_banco = C_Selic.Buscar_selic_completa();
        if(matriz_selic_banco == null)
            Label_Erro.setVisible(true);
        else
            Label_Erro.setVisible(false);
        modelo.setDados(matriz_selic_banco);
        Table_Selic.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel_Incidencia = new javax.swing.JPanel();
        B_Inserir_selic_completa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Label_Erro = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        B_Retornar = new javax.swing.JButton();
        Painel_Busca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Selic = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel_Incidencia.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Incidencia.setPreferredSize(new java.awt.Dimension(900, 160));

        B_Inserir_selic_completa.setBackground(new java.awt.Color(102, 102, 102));
        B_Inserir_selic_completa.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Inserir_selic_completa.setForeground(new java.awt.Color(0, 0, 0));
        B_Inserir_selic_completa.setText("Inserir/Atualizar Tabelas Selic");
        B_Inserir_selic_completa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Inserir_selic_completaActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Registros Selic");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        Label_Erro.setBackground(new java.awt.Color(153, 153, 153));
        Label_Erro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Label_Erro.setForeground(new java.awt.Color(153, 0, 0));
        Label_Erro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Erro.setText("Nenhum registro Selic armazenado");

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));

        B_Retornar.setBackground(new java.awt.Color(102, 102, 102));
        B_Retornar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Retornar.setForeground(new java.awt.Color(0, 0, 0));
        B_Retornar.setText("Retornar");
        B_Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Painel_IncidenciaLayout = new javax.swing.GroupLayout(Painel_Incidencia);
        Painel_Incidencia.setLayout(Painel_IncidenciaLayout);
        Painel_IncidenciaLayout.setHorizontalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_IncidenciaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(608, 608, 608)
                .addComponent(B_Retornar)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_IncidenciaLayout.createSequentialGroup()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B_Inserir_selic_completa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Erro, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Painel_IncidenciaLayout.setVerticalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(B_Retornar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Inserir_selic_completa)
                    .addComponent(Label_Erro))
                .addGap(34, 34, 34)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Painel_Incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        Painel_Busca.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Busca.setPreferredSize(new java.awt.Dimension(900, 340));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(888, 334));

        Table_Selic.setBackground(new java.awt.Color(153, 153, 153));
        Table_Selic.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Table_Selic.setForeground(new java.awt.Color(0, 0, 0));
        Table_Selic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Selic.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(Table_Selic);

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tabela de Juros Selic");

        javax.swing.GroupLayout Painel_BuscaLayout = new javax.swing.GroupLayout(Painel_Busca);
        Painel_Busca.setLayout(Painel_BuscaLayout);
        Painel_BuscaLayout.setHorizontalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Painel_BuscaLayout.setVerticalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Painel_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_Inserir_selic_completaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Inserir_selic_completaActionPerformed
        J_Gerenciar_selic j_selic = new J_Gerenciar_selic(this);
        j_selic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_Inserir_selic_completaActionPerformed

    private void B_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RetornarActionPerformed
        jj_inicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_RetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Inserir_selic_completa;
    private javax.swing.JButton B_Retornar;
    private javax.swing.JLabel Label_Erro;
    private javax.swing.JPanel Painel_Busca;
    private javax.swing.JPanel Painel_Incidencia;
    private javax.swing.JTable Table_Selic;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
