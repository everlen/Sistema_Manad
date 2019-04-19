/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Modelo_tabelas.Model_table_relatorio;
import Model.Modelo_tabelas.Model_table_resumo;
import Model.Relatorio;
import Model.Requisitos_busca;
import java.util.ArrayList;
import javax.swing.DefaultListModel;


/**
 *
 * @author Everlen
 */
public class J_Relatorio extends javax.swing.JFrame {
    Model_table_relatorio modelo_exibir = null;
    Model_table_resumo modelo_resumo = null;
    J_Inicial Jinicial;
    boolean [] registro_null = null, check_R;
    DefaultListModel model_requisitos = new DefaultListModel();
    public J_Relatorio(String Text_periodo, Requisitos_busca Requisitos, ArrayList<Relatorio> List_Relatorio, J_Inicial inicial) {
        
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        Jinicial = inicial;
        Jinicial.setVisible(false);
        modelo_exibir = new Model_table_relatorio();
        modelo_resumo = new Model_table_resumo();
        Label_periodo.setText(Text_periodo);
        
        if(registro_null == null){
            registro_null = modelo_exibir.setDados(List_Relatorio);
        }
        
        modelo_resumo.setDados(List_Relatorio);
        
        Check_K050.setSelected(registro_null[0]);
        Check_K100.setSelected(registro_null[1]);
        Check_K150.setSelected(registro_null[2]);
        Check_K200.setSelected(registro_null[3]);
        Check_K250.setSelected(registro_null[4]);
        Check_K300.setSelected(registro_null[5]);
        
        Check_K050.setVisible(false);
        Check_K100.setVisible(false);
        Check_K150.setVisible(false);
        Check_K200.setVisible(false);
        Check_K250.setVisible(false);
        Check_K300.setVisible(false);
        Painel_Check.setVisible(false);
        
        Table_Relatorio.setModel(modelo_resumo);
        Lista_Requisitos.setModel(model_requisitos);
        if(Requisitos!=null)
            Escrever_requisitos(Requisitos);
        else{
            Lista_Requisitos.setVisible(false);
            Scroll_lista_requisitos.setVisible(false);
        }
            
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Label_periodo = new javax.swing.JLabel();
        Scroll_lista_requisitos = new javax.swing.JScrollPane();
        Lista_Requisitos = new javax.swing.JList<>();
        Painel_Check = new javax.swing.JPanel();
        Check_K050 = new javax.swing.JCheckBox();
        Check_K100 = new javax.swing.JCheckBox();
        Check_K150 = new javax.swing.JCheckBox();
        Check_K200 = new javax.swing.JCheckBox();
        Check_K250 = new javax.swing.JCheckBox();
        Check_K300 = new javax.swing.JCheckBox();
        Painel_rolagem = new javax.swing.JScrollPane();
        Table_Relatorio = new javax.swing.JTable();
        B_Retornar = new javax.swing.JButton();
        B_Exibir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        Label_periodo.setBackground(new java.awt.Color(204, 204, 204));
        Label_periodo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Label_periodo.setForeground(new java.awt.Color(0, 0, 0));
        Label_periodo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Label_periodo.setText("Text_periodo");
        Label_periodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Lista_Requisitos.setBackground(new java.awt.Color(204, 204, 204));
        Lista_Requisitos.setVisibleRowCount(2);
        Scroll_lista_requisitos.setViewportView(Lista_Requisitos);

        Painel_Check.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Painel_Check.setEnabled(false);

        Check_K050.setText("K050");
        Check_K050.setEnabled(false);
        Check_K050.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        Check_K100.setText("K100");
        Check_K100.setEnabled(false);
        Check_K100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        Check_K150.setText("K150");
        Check_K150.setEnabled(false);
        Check_K150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        Check_K200.setText("K200");
        Check_K200.setEnabled(false);
        Check_K200.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        Check_K250.setText("K250");
        Check_K250.setEnabled(false);
        Check_K250.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        Check_K300.setText("K300");
        Check_K300.setEnabled(false);
        Check_K300.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Atualizar_tabela(evt);
            }
        });

        javax.swing.GroupLayout Painel_CheckLayout = new javax.swing.GroupLayout(Painel_Check);
        Painel_Check.setLayout(Painel_CheckLayout);
        Painel_CheckLayout.setHorizontalGroup(
            Painel_CheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_CheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Check_K050)
                .addGap(18, 18, 18)
                .addComponent(Check_K100)
                .addGap(18, 18, 18)
                .addComponent(Check_K150)
                .addGap(18, 18, 18)
                .addComponent(Check_K200)
                .addGap(18, 18, 18)
                .addComponent(Check_K250)
                .addGap(18, 18, 18)
                .addComponent(Check_K300)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Painel_CheckLayout.setVerticalGroup(
            Painel_CheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_CheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_CheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Check_K050)
                    .addComponent(Check_K100)
                    .addComponent(Check_K150)
                    .addComponent(Check_K200)
                    .addComponent(Check_K250)
                    .addComponent(Check_K300))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Painel_rolagem.setBackground(new java.awt.Color(204, 204, 204));
        Painel_rolagem.setForeground(new java.awt.Color(0, 0, 0));

        Table_Relatorio.setBackground(new java.awt.Color(153, 153, 153));
        Table_Relatorio.setForeground(new java.awt.Color(0, 0, 0));
        Table_Relatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table_Relatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Painel_rolagem.setViewportView(Table_Relatorio);

        B_Retornar.setBackground(new java.awt.Color(102, 102, 102));
        B_Retornar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        B_Retornar.setForeground(new java.awt.Color(0, 0, 0));
        B_Retornar.setText("Retornar");
        B_Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RetornarActionPerformed(evt);
            }
        });

        B_Exibir.setBackground(new java.awt.Color(102, 102, 102));
        B_Exibir.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        B_Exibir.setForeground(new java.awt.Color(0, 0, 0));
        B_Exibir.setText("Exibir Registros");
        B_Exibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ExibirActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Relatório MANAD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Scroll_lista_requisitos, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(Label_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Painel_Check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(B_Exibir, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(B_Retornar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(Painel_rolagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Scroll_lista_requisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Painel_Check, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(B_Retornar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Exibir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_periodo)))
                    .addGap(71, 71, 71)
                    .addComponent(Painel_rolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Atualizar_tabela(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atualizar_tabela
        
        modelo_exibir.Atualizar_coluna(Check_K050.isSelected(), Check_K100.isSelected(), Check_K150.isSelected(), Check_K200.isSelected(), Check_K250.isSelected(), Check_K300.isSelected());
       
    }//GEN-LAST:event_Atualizar_tabela

    private void B_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RetornarActionPerformed
        Jinicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_RetornarActionPerformed

    private void B_ExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ExibirActionPerformed
        
        if(B_Exibir.getText().equals("Exibir Registros")){
            Table_Relatorio.setModel(modelo_exibir);
            B_Exibir.setText("Ocultar Registros");
            
            Check_K050.setEnabled(registro_null[0]);
            Check_K100.setEnabled(registro_null[1]);
            Check_K150.setEnabled(registro_null[2]);
            Check_K200.setEnabled(registro_null[3]);
            Check_K250.setEnabled(registro_null[4]);
            Check_K300.setEnabled(registro_null[5]);
            Check_K050.setVisible(true);
            Check_K100.setVisible(true);
            Check_K150.setVisible(true);
            Check_K200.setVisible(true);
            Check_K250.setVisible(true);
            Check_K300.setVisible(true);
            Painel_Check.setVisible(true);
        }
        else{
            Table_Relatorio.setModel(modelo_resumo);
            B_Exibir.setText("Exibir Registros");
            
            Check_K050.setVisible(false);
            Check_K100.setVisible(false);
            Check_K150.setVisible(false);
            Check_K200.setVisible(false);
            Check_K250.setVisible(false);
            Check_K300.setVisible(false);
            Painel_Check.setVisible(false);
        }
    }//GEN-LAST:event_B_ExibirActionPerformed

    private void Escrever_requisitos(Requisitos_busca Requisitos){
        String string = "Requisitos do Relatório | ";
        if(Requisitos.getTipo_folha()!=null){
            string+= "IND_FL: ";
            int i =0;
            for(String s: Requisitos.getTipo_folha()){
                if(i>0)
                    string +=", ";
                string += s;   
                i++;
            }
            string+= " | ";
        }
        if(Requisitos.getCod_rubr()!=null){
            string+= "COD_RUBR: ";
            int i =0;
            for(String s: Requisitos.getCod_rubr()){
                if(i>0)
                    string +=", ";
                string += s;   
                i++;
            }
            string+= " | ";
        }
        if(Requisitos.getCod_ltc()!=null){
            string+= "COD_LTC: ";
            int i =0;
            for(String s: Requisitos.getCod_ltc()){
                if(i>0)
                    string +=", ";
                string += s; 
                i++;
            }
            string+= " | ";
        }
        if(Requisitos.getInd_base_ps()!=null){
            string+= "IND_BASE_PS: ";
            int i =0;
            for(String s: Requisitos.getInd_base_ps()){
                if(i>0)
                    string +=", ";
                string += s;   
                i++;
            }
            string+= " | ";
        }
        
        
        model_requisitos.addElement(string);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Exibir;
    private javax.swing.JButton B_Retornar;
    private javax.swing.JCheckBox Check_K050;
    private javax.swing.JCheckBox Check_K100;
    private javax.swing.JCheckBox Check_K150;
    private javax.swing.JCheckBox Check_K200;
    private javax.swing.JCheckBox Check_K250;
    private javax.swing.JCheckBox Check_K300;
    private javax.swing.JLabel Label_periodo;
    private javax.swing.JList<String> Lista_Requisitos;
    private javax.swing.JPanel Painel_Check;
    private javax.swing.JScrollPane Painel_rolagem;
    private javax.swing.JScrollPane Scroll_lista_requisitos;
    private javax.swing.JTable Table_Relatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
