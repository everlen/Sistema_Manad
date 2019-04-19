/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.C_Apuraçao;
import Controller.C_Pdf;
import Controller.C_Selic;
import Model.Rubrica_apuraçao;
import Model.Modelo_tabelas.Model_table_rubr;
import Model.Selic;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Victony
 */
public class J_Listagem_rubrica extends javax.swing.JFrame {

    Model_table_rubr modelo;
    J_Inicial jj_inicial;
    DefaultListModel modelo_list_itens = new DefaultListModel();
    ArrayList<Rubrica_apuraçao> list_itens_selecionados = null, lista_all_rubrica, lista_rubrica_tabela_atual;
    int size_busca = 0;
    C_Apuraçao c_apuraçao = null;
    
    public J_Listagem_rubrica(J_Inicial j_inicial, ArrayList<Rubrica_apuraçao> list_itens_selecionados_recebida) {
        initComponents();
        this.setLocationRelativeTo(null);
        jj_inicial = j_inicial;
        modelo = new Model_table_rubr();
        lista_all_rubrica = C_Apuraçao.Buscar_todos_item_apuraçao();
        lista_rubrica_tabela_atual = lista_all_rubrica;
        modelo.setDados(lista_rubrica_tabela_atual);
        Table_Rubr.setModel(modelo);
        List_Rubricas_selecionadas.setModel(modelo_list_itens);
        Label_Erro.setText("");
        if(list_itens_selecionados_recebida != null){
            list_itens_selecionados = new ArrayList<Rubrica_apuraçao>();
            for(Rubrica_apuraçao rubr : list_itens_selecionados_recebida){
                list_itens_selecionados.add(rubr);
                modelo_list_itens.addElement(rubr.getRubrica());
            }
        }
        c_apuraçao = new C_Apuraçao();
        c_apuraçao.Iniciar_filtro_apuraçao(lista_all_rubrica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel_Incidencia = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        B_Retornar = new javax.swing.JButton();
        Text_Filtrar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Painel_Busca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Rubr = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        B_Adicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Rubricas_selecionadas = new javax.swing.JList<>();
        B_Remover = new javax.swing.JButton();
        B_Limpar = new javax.swing.JButton();
        Check_Filtrar_inss = new javax.swing.JCheckBox();
        Label_Erro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel_Incidencia.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Incidencia.setPreferredSize(new java.awt.Dimension(900, 160));

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Registros Selic");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

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

        Text_Filtrar.setBackground(new java.awt.Color(153, 153, 153));
        Text_Filtrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Text_FiltrarKeyReleased(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Buscar");

        javax.swing.GroupLayout Painel_IncidenciaLayout = new javax.swing.GroupLayout(Painel_Incidencia);
        Painel_Incidencia.setLayout(Painel_IncidenciaLayout);
        Painel_IncidenciaLayout.setHorizontalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_Retornar)
                        .addGap(17, 17, 17))))
        );
        Painel_IncidenciaLayout.setVerticalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Retornar)
                    .addComponent(Text_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Painel_Incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        Painel_Busca.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Busca.setPreferredSize(new java.awt.Dimension(900, 340));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(888, 334));

        Table_Rubr.setBackground(new java.awt.Color(153, 153, 153));
        Table_Rubr.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Table_Rubr.setForeground(new java.awt.Color(0, 0, 0));
        Table_Rubr.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Rubr.setGridColor(new java.awt.Color(102, 102, 102));
        Table_Rubr.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(Table_Rubr);

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tabela de Rubricas");

        B_Adicionar.setBackground(new java.awt.Color(102, 102, 102));
        B_Adicionar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Adicionar.setForeground(new java.awt.Color(0, 0, 0));
        B_Adicionar.setText("Adicionar Rubrica a Lista de Busca");
        B_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N

        List_Rubricas_selecionadas.setBackground(new java.awt.Color(153, 153, 153));
        List_Rubricas_selecionadas.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        List_Rubricas_selecionadas.setForeground(new java.awt.Color(0, 0, 0));
        List_Rubricas_selecionadas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Lista de Rubricas" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        List_Rubricas_selecionadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(List_Rubricas_selecionadas);

        B_Remover.setBackground(new java.awt.Color(153, 153, 153));
        B_Remover.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Remover.setForeground(new java.awt.Color(0, 0, 0));
        B_Remover.setText("Remover Rubrica");
        B_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RemoverActionPerformed(evt);
            }
        });

        B_Limpar.setBackground(new java.awt.Color(153, 153, 153));
        B_Limpar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Limpar.setForeground(new java.awt.Color(0, 0, 0));
        B_Limpar.setText("Limpar Lista");
        B_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LimparActionPerformed(evt);
            }
        });

        Check_Filtrar_inss.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Check_Filtrar_inss.setText("Apenas indicadores de previdencia social = 1");
        Check_Filtrar_inss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_Filtrar_inssActionPerformed(evt);
            }
        });

        Label_Erro.setBackground(new java.awt.Color(153, 153, 153));
        Label_Erro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Label_Erro.setForeground(new java.awt.Color(153, 0, 0));
        Label_Erro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Erro.setText("Erro");

        javax.swing.GroupLayout Painel_BuscaLayout = new javax.swing.GroupLayout(Painel_Busca);
        Painel_Busca.setLayout(Painel_BuscaLayout);
        Painel_BuscaLayout.setHorizontalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_Adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                                .addComponent(B_Remover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(B_Limpar))))
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(Check_Filtrar_inss)
                        .addGap(18, 18, 18)
                        .addComponent(Label_Erro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Painel_BuscaLayout.setVerticalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Check_Filtrar_inss)
                    .addComponent(Label_Erro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(B_Adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Remover)
                            .addComponent(B_Limpar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Painel_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RetornarActionPerformed
        jj_inicial.setList_rubrica(list_itens_selecionados);
        jj_inicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_RetornarActionPerformed

    private void B_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AdicionarActionPerformed
        if(list_itens_selecionados == null)
            list_itens_selecionados = new ArrayList<Rubrica_apuraçao>();
        
        ArrayList<Rubrica_apuraçao> list_rubr = modelo.getList_apuraçao();
        list_itens_selecionados.add(list_rubr.get(Table_Rubr.getSelectedRow()));
        modelo_list_itens.addElement(list_rubr.get(Table_Rubr.getSelectedRow()).getRubrica());
    }//GEN-LAST:event_B_AdicionarActionPerformed

    private void B_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RemoverActionPerformed
        if(!List_Rubricas_selecionadas.isSelectionEmpty()){
            list_itens_selecionados.remove(List_Rubricas_selecionadas.getSelectedIndex());
            modelo_list_itens.remove(List_Rubricas_selecionadas.getSelectedIndex());
            Label_Erro.setText("Rubrica Removida da Lista");
        }
    }//GEN-LAST:event_B_RemoverActionPerformed

    private void B_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LimparActionPerformed
        list_itens_selecionados = new ArrayList<Rubrica_apuraçao>();
        modelo_list_itens.removeAllElements();
        Label_Erro.setText("Todas as Rubricas foram Removidas");
    }//GEN-LAST:event_B_LimparActionPerformed

    private void Check_Filtrar_inssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_Filtrar_inssActionPerformed
        lista_rubrica_tabela_atual = c_apuraçao.Buscar(Text_Filtrar.getText(), Check_Filtrar_inss.isSelected());       
        modelo.setDados(lista_rubrica_tabela_atual);
        
    }//GEN-LAST:event_Check_Filtrar_inssActionPerformed

    private void Text_FiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_FiltrarKeyReleased
        lista_rubrica_tabela_atual = c_apuraçao.Buscar(Text_Filtrar.getText(), Check_Filtrar_inss.isSelected());       
        modelo.setDados(lista_rubrica_tabela_atual);
    }//GEN-LAST:event_Text_FiltrarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Adicionar;
    private javax.swing.JButton B_Limpar;
    private javax.swing.JButton B_Remover;
    private javax.swing.JButton B_Retornar;
    private javax.swing.JCheckBox Check_Filtrar_inss;
    private javax.swing.JLabel Label_Erro;
    private javax.swing.JList<String> List_Rubricas_selecionadas;
    private javax.swing.JPanel Painel_Busca;
    private javax.swing.JPanel Painel_Incidencia;
    private javax.swing.JTable Table_Rubr;
    private javax.swing.JTextField Text_Filtrar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
