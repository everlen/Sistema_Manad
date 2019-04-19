/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.C_Anexo_manad;
import Controller.C_Apuraçao;
import Controller.C_Folha_pagamento;
import Controller.C_K100;
import Controller.C_K150;
import Controller.C_Pdf;
import Controller.C_Relatorios;
import Controller.Filtrar_arquivo;
import Model.Apuraçao;
import Model.Empresa;
import Model.Folha_pagamento;
import Model.Rubrica_apuraçao;
import Model.Item_pesquisa;
import Model.K100;
import Model.K150;
import Model.Relatorio;
import Model.Requisitos_busca;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Victony
 */
public class J_Inicial extends javax.swing.JFrame{
    boolean correto;
    ArrayList<String> list_erros;
    J_Relatorio j_relatorio = null;
    ArrayList<K100> list_k100;
    ArrayList<Rubrica_apuraçao> list_rubrica = null;
    Empresa empresa = null;
    ArrayList<Item_pesquisa> list_itens = null;
    DefaultListModel list_itens_modelo = new DefaultListModel();
    String Dados_empresa;
    
    public J_Inicial() {
        initComponents();
        this.setLocationRelativeTo(null);
        C_Anexo_manad.Limpar_banco();
        Label_Erro.setText("");
        UIManager.put("ProgressBar.selectionBackground", new Color(102, 102, 102));
        
        for(int i = 0; i< Painel_Busca.getComponentCount(); i++){
            Painel_Busca.getComponent(i).setEnabled(false);
        }
        List_Itens_busca.setModel(list_itens_modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel_Armazenar = new javax.swing.JPanel();
        B_Armazenar_manad = new javax.swing.JButton();
        B_Atualizar_selic = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Label_Nome_empresa = new javax.swing.JLabel();
        Progressbar = new javax.swing.JProgressBar();
        Label_Erro = new javax.swing.JLabel();
        Painel_Busca = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Combo_Mes_inicial = new javax.swing.JComboBox<>();
        Combo_Ano_inicial = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Combo_Mes_final = new javax.swing.JComboBox<>();
        Combo_Ano_final = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Combo_Indicador_folha = new javax.swing.JComboBox<>();
        B_Add_folha = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Combo_Lotaçao = new javax.swing.JComboBox<>();
        B_Add_ltc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Combo_Ind_base_ps = new javax.swing.JComboBox<>();
        B_Add_ps = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Itens_busca = new javax.swing.JList<>();
        B_Buscar = new javax.swing.JButton();
        B_Remover = new javax.swing.JButton();
        B_Limpar = new javax.swing.JButton();
        B_Listar_rubrica = new javax.swing.JButton();
        B_Realizar_apuraçao = new javax.swing.JButton();
        Label_Nome_empresa1 = new javax.swing.JLabel();
        B_Criar_folha_pagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel_Armazenar.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Armazenar.setPreferredSize(new java.awt.Dimension(900, 160));

        B_Armazenar_manad.setBackground(new java.awt.Color(102, 102, 102));
        B_Armazenar_manad.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Armazenar_manad.setForeground(new java.awt.Color(0, 0, 0));
        B_Armazenar_manad.setText("Inserir Arquivo MANAD");
        B_Armazenar_manad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Armazenar_manadActionPerformed(evt);
            }
        });

        B_Atualizar_selic.setBackground(new java.awt.Color(102, 102, 102));
        B_Atualizar_selic.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Atualizar_selic.setForeground(new java.awt.Color(0, 0, 0));
        B_Atualizar_selic.setText("Atualizar Tabela de Juros Selic");
        B_Atualizar_selic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Atualizar_selicActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nome do Software");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));

        Label_Nome_empresa.setBackground(new java.awt.Color(153, 153, 153));
        Label_Nome_empresa.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        Label_Nome_empresa.setForeground(new java.awt.Color(0, 0, 0));
        Label_Nome_empresa.setText("Insira o Arquivo MANAD para Iniciar a Apuração");

        Progressbar.setBackground(new java.awt.Color(102, 102, 102));
        Progressbar.setForeground(new java.awt.Color(255, 255, 255));

        Label_Erro.setBackground(new java.awt.Color(153, 153, 153));
        Label_Erro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Label_Erro.setForeground(new java.awt.Color(153, 0, 0));
        Label_Erro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Erro.setText("Erro");

        javax.swing.GroupLayout Painel_ArmazenarLayout = new javax.swing.GroupLayout(Painel_Armazenar);
        Painel_Armazenar.setLayout(Painel_ArmazenarLayout);
        Painel_ArmazenarLayout.setHorizontalGroup(
            Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_ArmazenarLayout.createSequentialGroup()
                .addGroup(Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Nome_empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                                .addGroup(Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(B_Armazenar_manad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                                        .addGroup(Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Progressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Erro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B_Atualizar_selic, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)))))
                .addContainerGap())
        );
        Painel_ArmazenarLayout.setVerticalGroup(
            Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Armazenar_manad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_ArmazenarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B_Atualizar_selic)
                    .addGroup(Painel_ArmazenarLayout.createSequentialGroup()
                        .addComponent(Progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Erro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Nome_empresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Painel_Armazenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 160));

        Painel_Busca.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Busca.setPreferredSize(new java.awt.Dimension(900, 340));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Período");

        Combo_Mes_inicial.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Mes_inicial.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Mes_inicial.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Mes_inicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        Combo_Ano_inicial.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Ano_inicial.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Ano_inicial.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Ano_inicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano Inicial" }));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("até");

        Combo_Mes_final.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Mes_final.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Mes_final.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Mes_final.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        Combo_Ano_final.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Ano_final.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Ano_final.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Ano_final.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano Final" }));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Rubrica");

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Tipo de Folha");

        Combo_Indicador_folha.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Indicador_folha.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Indicador_folha.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Indicador_folha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Folha Normal", "2 - Folha de 13º salário", "3 - Folha de Férias", "4 - Folha Complementar à normal", "5 - Folha Complementar ao 13º", ">= 6 - Outras Folhas" }));

        B_Add_folha.setBackground(new java.awt.Color(102, 102, 102));
        B_Add_folha.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Add_folha.setForeground(new java.awt.Color(0, 0, 0));
        B_Add_folha.setText("+");
        B_Add_folha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Add_folhaActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Lotação");

        Combo_Lotaçao.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Lotaçao.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Lotaçao.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Lotaçao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrição - Cod", " " }));

        B_Add_ltc.setBackground(new java.awt.Color(102, 102, 102));
        B_Add_ltc.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Add_ltc.setForeground(new java.awt.Color(0, 0, 0));
        B_Add_ltc.setText("+");
        B_Add_ltc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Add_ltcActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Previdência Social");

        Combo_Ind_base_ps.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Ind_base_ps.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Ind_base_ps.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Ind_base_ps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Contribuinte Mensal", "2 - 13º Salário", "3 - Descontado do Segurado", "4 - Salário Familia", "5 - Salário Maternidade", "6 - FGTS", "7 - Reduções da Base de Cálculo", "8 - Não é Base de Cálculo", "9 - Outras Bases de Cálculo" }));

        B_Add_ps.setBackground(new java.awt.Color(102, 102, 102));
        B_Add_ps.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Add_ps.setForeground(new java.awt.Color(0, 0, 0));
        B_Add_ps.setText("+");
        B_Add_ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Add_psActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Parâmetros Selecionados");

        List_Itens_busca.setBackground(new java.awt.Color(153, 153, 153));
        List_Itens_busca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        List_Itens_busca.setForeground(new java.awt.Color(0, 0, 0));
        List_Itens_busca.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Lista de parametros", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(List_Itens_busca);

        B_Buscar.setBackground(new java.awt.Color(102, 102, 102));
        B_Buscar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Buscar.setForeground(new java.awt.Color(0, 0, 0));
        B_Buscar.setText("Buscar Registros");
        B_Buscar.setEnabled(false);
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        B_Remover.setBackground(new java.awt.Color(153, 153, 153));
        B_Remover.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Remover.setForeground(new java.awt.Color(0, 0, 0));
        B_Remover.setText("Remover Item");
        B_Remover.setEnabled(false);
        B_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RemoverActionPerformed(evt);
            }
        });

        B_Limpar.setBackground(new java.awt.Color(153, 153, 153));
        B_Limpar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Limpar.setForeground(new java.awt.Color(0, 0, 0));
        B_Limpar.setText("Limpar Lista");
        B_Limpar.setEnabled(false);
        B_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LimparActionPerformed(evt);
            }
        });

        B_Listar_rubrica.setBackground(new java.awt.Color(102, 102, 102));
        B_Listar_rubrica.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Listar_rubrica.setForeground(new java.awt.Color(0, 0, 0));
        B_Listar_rubrica.setText("Exibir Tabela de Rubricas para Inserção na Lista");
        B_Listar_rubrica.setEnabled(false);
        B_Listar_rubrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Listar_rubricaActionPerformed(evt);
            }
        });

        B_Realizar_apuraçao.setBackground(new java.awt.Color(102, 102, 102));
        B_Realizar_apuraçao.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Realizar_apuraçao.setForeground(new java.awt.Color(0, 0, 0));
        B_Realizar_apuraçao.setText("Realizar Relatório de Apuração ");
        B_Realizar_apuraçao.setEnabled(false);
        B_Realizar_apuraçao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Realizar_apuraçaoActionPerformed(evt);
            }
        });

        Label_Nome_empresa1.setBackground(new java.awt.Color(153, 153, 153));
        Label_Nome_empresa1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        Label_Nome_empresa1.setForeground(new java.awt.Color(0, 0, 0));
        Label_Nome_empresa1.setText("Filtros para a Busca ou Apuração dos Registros");

        B_Criar_folha_pagamento.setBackground(new java.awt.Color(102, 102, 102));
        B_Criar_folha_pagamento.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Criar_folha_pagamento.setForeground(new java.awt.Color(0, 0, 0));
        B_Criar_folha_pagamento.setText("Gerar Folha de Pagamento");
        B_Criar_folha_pagamento.setEnabled(false);
        B_Criar_folha_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Criar_folha_pagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Painel_BuscaLayout = new javax.swing.GroupLayout(Painel_Busca);
        Painel_Busca.setLayout(Painel_BuscaLayout);
        Painel_BuscaLayout.setHorizontalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(Label_Nome_empresa1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel_BuscaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel_BuscaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_Listar_rubrica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                                .addComponent(B_Criar_folha_pagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(B_Realizar_apuraçao))
                            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Combo_Lotaçao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Combo_Ind_base_ps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Combo_Indicador_folha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(B_Add_folha, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(B_Add_ps, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(B_Add_ltc)))
                                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                                        .addComponent(Combo_Mes_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Combo_Ano_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(Combo_Mes_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Combo_Ano_final, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(B_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_Remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B_Limpar)))
                .addContainerGap())
        );
        Painel_BuscaLayout.setVerticalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                .addComponent(Label_Nome_empresa1)
                .addGap(15, 15, 15)
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Listar_rubrica)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Combo_Mes_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_Ano_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Combo_Mes_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_Ano_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Combo_Indicador_folha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Add_folha))
                        .addGap(18, 18, 18)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Combo_Lotaçao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Add_ltc))
                        .addGap(18, 18, 18)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Ind_base_ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Add_ps)
                            .addComponent(jLabel9)))
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Remover)
                            .addComponent(B_Limpar)
                            .addComponent(B_Buscar))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Criar_folha_pagamento)
                            .addComponent(B_Realizar_apuraçao))
                        .addContainerGap())))
        );

        getContentPane().add(Painel_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 900, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_Listar_rubricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Listar_rubricaActionPerformed
        J_Listagem_rubrica j_listagem_rubrica = new J_Listagem_rubrica(this, list_rubrica);
        j_listagem_rubrica.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_B_Listar_rubricaActionPerformed

    private void B_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LimparActionPerformed
        list_itens = new ArrayList<Item_pesquisa>();
        list_rubrica = null;
        list_itens_modelo.removeAllElements();
    }//GEN-LAST:event_B_LimparActionPerformed

    private void B_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RemoverActionPerformed
        if(!List_Itens_busca.isSelectionEmpty()){
            if(list_itens.get(List_Itens_busca.getSelectedIndex()).getTipo_item() == 1){
                for(Rubrica_apuraçao item: list_rubrica){
                    if(Integer.parseInt(item.getCod()) == list_itens.get(List_Itens_busca.getSelectedIndex()).getIndice_item()){
                        list_rubrica.remove(item);
                        break;
                    }                        
                }
             
            }               
            list_itens.remove(List_Itens_busca.getSelectedIndex());
            list_itens_modelo.remove(List_Itens_busca.getSelectedIndex());
        }
    }//GEN-LAST:event_B_RemoverActionPerformed

    private void B_Armazenar_manadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Armazenar_manadActionPerformed
        Label_Erro.setText("");        
        list_erros = new ArrayList<String>();
        correto = true;
            Progressbar.setValue(0);
        
        Runnable ativar = new Runnable() {
            public void run() {
                Progressbar.setIndeterminate(true);
                Label_Erro.setText("Inserindo arquivo MANAD...");
                Label_Erro.setVisible(true);
            }
        };     
        
        Runnable inserir = new Runnable() {
            public void run() {
//Obter arquivo    
                byte[] arquivo = null;
                JFileChooser J_file = new JFileChooser(); 
                J_file.showOpenDialog(J_file);
                File file = null;
                FileInputStream inFile  = null;

                if(J_file.getSelectedFile()!=null){

                    file = J_file.getSelectedFile().getAbsoluteFile();              
                    arquivo = new byte[(int) file.length()];

                    try {   
                        if(file.getName().endsWith(".txt")){
                            inFile = new FileInputStream(file);
                            inFile.read(arquivo, 0, (int) file.length());
                        }
                        else
                            correto = false;

                    } catch (FileNotFoundException ex) {
                        correto = false;
                    } catch (IOException ex) {
                        correto = false;
                    }

                }
                else{
                    correto = false;
                }

                if(correto){
//Leitura de arquivo

                    FileReader FR_file = null;
                    try {
                        FR_file = new FileReader(file);

                    } catch (FileNotFoundException ex) {
                        correto = false;
                        list_erros.add("Não foi possivel ler o arquivo");
                    } 
                    if(correto){

                        C_Anexo_manad.Limpar_banco();
                        empresa = Filtrar_arquivo.Inserir_registros(FR_file);                
                        if(empresa != null){
//Inserir Anexo no banco        
                            correto = C_Anexo_manad.Inserir(empresa.getCNPJ());

                            if(!correto){
                                correto = false;
                                list_erros.add("Não foi possivel inserir o arquivo no banco de dados");
                            }                       
                            else{

                                list_k100 = C_K100.Buscar_existentes();
                                Combo_Lotaçao.removeAllItems();

                                if(list_k100 == null){
                                    Combo_Lotaçao.setEnabled(false);
                                    B_Add_ltc.setEnabled(false);
                                }
                                else{
                                    for(K100 k100: list_k100){
                                        Combo_Lotaçao.addItem(k100.getCod_ltc()+" - "+k100.getDesc_ltc()); 
                                    }
                                    Combo_Lotaçao.setEnabled(true);
                                    B_Add_ltc.setEnabled(true);
                                }  

                                list_erros.add("Arquivo MANAD inserido com sucesso!");

// Escrevendo dados da empresa no Label

                                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                String texto_empresa = empresa.getNome() +" | CNPJ: ";
                                Dados_empresa = empresa.getNome();
                                Dados_empresa = Dados_empresa.substring(0, 15);

                                Dados_empresa.replaceAll("_", " ");
                                boolean aux_empresa = false;
                                for(String s: empresa.getCNPJ()){ 
                                    if(aux_empresa)
                                        texto_empresa+= ", ";
                                    else
                                        aux_empresa = true;
                                    texto_empresa+= s;
                                }
                                texto_empresa+= " | Periodo Referente de " +formato.format(empresa.getInicio())+ " a "+formato.format(empresa.getFim());
                                Label_Nome_empresa.setText(texto_empresa);
                                Label_Nome_empresa.setVisible(true);
//Definindo data limite e minima para escolha    
                                Combo_Ano_inicial.removeAllItems();
                                Combo_Ano_final.removeAllItems();

                                SimpleDateFormat df = new SimpleDateFormat("MM");
                                Combo_Mes_final.setSelectedIndex(Integer.parseInt(df.format(empresa.getFim())) - 1);

                                df = new SimpleDateFormat("yyyy");
                                int ano_inicial = Integer.parseInt(df.format(empresa.getInicio()));
                                int ano_final = Integer.parseInt(df.format(empresa.getFim()));                       
                                for(int i = ano_inicial; i<= ano_final; i++){
                                    Combo_Ano_inicial.addItem(String.valueOf(i));
                                    Combo_Ano_final.addItem(String.valueOf(i));
                                }

                                Combo_Ano_final.setSelectedIndex(Combo_Ano_final.getItemCount() - 1);


                                for(int i = 0; i< Painel_Busca.getComponentCount(); i++){
                                    Painel_Busca.getComponent(i).setEnabled(true);
                                }
                                list_itens = new ArrayList<Item_pesquisa>();

                            }
                            
                        }
                        else{
                            correto = false;
                            list_erros.add("Não foi encontrado registros MANAD neste arquivo");
                        }
                    }
                }
                else{
                    correto = false;
                    list_erros.add("Nenhum Documento foi selecionado");
                }
                Progressbar.setIndeterminate(false);
                Progressbar.setValue(100);
                if(!correto && empresa == null){
// Bloquear campos de busca            
                    for(int i = 0; i< Painel_Busca.getComponentCount(); i++){
                        Painel_Busca.getComponent(i).setEnabled(false);
                    }  
                }
                
                Label_Erro.setText("");
                for(String erro: list_erros)
                    Label_Erro.setText(Label_Erro.getText() + " " + erro);
            }
        }; 
        
        Thread processo_progress, processo_inserir;
        processo_progress = new Thread(ativar);
        processo_progress.start(); 
        processo_inserir = new Thread(inserir);
        processo_inserir.start();
      

  
    }//GEN-LAST:event_B_Armazenar_manadActionPerformed

    private void B_Add_folhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Add_folhaActionPerformed
        Item_pesquisa item = new Item_pesquisa();
        item.setNome_tipo("IND_FL: ");
        item.setNome_item(Combo_Indicador_folha.getItemAt(Combo_Indicador_folha.getSelectedIndex()));
        item.setTipo_item(0);
        item.setIndice_item(Combo_Indicador_folha.getSelectedIndex());

        boolean existente = false;
        for(Item_pesquisa item_aux:list_itens)
        if(item_aux.getTipo_item() == item.getTipo_item())
        if(item_aux.getIndice_item() == item.getIndice_item())
        existente = true;

        if(!existente){
            list_itens.add(item);
            list_itens_modelo.addElement(item.getNome_tipo() + item.getNome_item());
        }
    }//GEN-LAST:event_B_Add_folhaActionPerformed

    private void B_Add_ltcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Add_ltcActionPerformed
        Item_pesquisa item = new Item_pesquisa();
        item.setNome_tipo("COD_LTC: ");
        item.setNome_item(Combo_Lotaçao.getItemAt(Combo_Lotaçao.getSelectedIndex()));
        item.setTipo_item(2);
        item.setIndice_item(Combo_Lotaçao.getSelectedIndex());

        boolean existente = false;
        for(Item_pesquisa item_aux:list_itens)
        if(item_aux.getTipo_item() == item.getTipo_item())
        if(item_aux.getIndice_item() == item.getIndice_item())
        existente = true;

        if(!existente){
            list_itens.add(item);
            list_itens_modelo.addElement(item.getNome_tipo() + item.getNome_item());
        }
    }//GEN-LAST:event_B_Add_ltcActionPerformed

    private void B_Add_psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Add_psActionPerformed
        Item_pesquisa item = new Item_pesquisa();
        item.setNome_tipo("IND_B_PS: ");
        item.setNome_item(Combo_Ind_base_ps.getItemAt(Combo_Ind_base_ps.getSelectedIndex()));
        item.setTipo_item(3);
        item.setIndice_item(Combo_Ind_base_ps.getSelectedIndex());

        boolean existente = false;
        for(Item_pesquisa item_aux:list_itens)
        if(item_aux.getTipo_item() == item.getTipo_item())
        if(item_aux.getIndice_item() == item.getIndice_item())
        existente = true;

        if(!existente){
            list_itens.add(item);
            list_itens_modelo.addElement(item.getNome_tipo() + item.getNome_item());
        }
    }//GEN-LAST:event_B_Add_psActionPerformed

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
        list_erros = new ArrayList<String>();
        Progressbar.setValue(0);
        Label_Erro.setText("");
        String string_date_inicial = String.valueOf(Combo_Mes_inicial.getSelectedIndex()+1) + "/" + Combo_Ano_inicial.getSelectedItem();
        String string_date_final = String.valueOf(Combo_Mes_final.getSelectedIndex()+1) + "/" + Combo_Ano_final.getSelectedItem();
        
        SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
        Date periodo_inicial = null;
        Date periodo_final = null;
        try {
            periodo_inicial = formato.parse(string_date_inicial);
            periodo_final = formato.parse(string_date_final);
        } catch (ParseException ex) {
            Logger.getLogger(J_Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        if(periodo_inicial.getTime() > periodo_final.getTime()){
            periodo_inicial = null;
            periodo_final = null;
        }

        Requisitos_busca requisitos = null;
        if(list_itens.size()>0){
            ArrayList<String> cod_rubr = null;
            ArrayList<String> tipo_folha = null;
            ArrayList<String> cod_ltc = null;
            ArrayList<String> ind_base_ps = null;

            if(list_rubrica != null && list_rubrica.size() > 0){
                cod_rubr = new ArrayList<String>();
                for(Rubrica_apuraçao rubrica : list_rubrica){
                    cod_rubr.add(rubrica.getCod());
                }
            }
            
            for(Item_pesquisa item : list_itens){
                if(item.getTipo_item()==0){
                    if(tipo_folha == null)
                        tipo_folha = new ArrayList<String>();
                    tipo_folha.add(String.valueOf(item.getIndice_item()+1));
                }
                else if(item.getTipo_item()==2){
                    if(cod_ltc == null)
                        cod_ltc = new ArrayList<String>();
                    cod_ltc.add(list_k100.get(item.getIndice_item()).getCod_ltc());
                }
                else if(item.getTipo_item()==3){
                    if(ind_base_ps == null)
                        ind_base_ps = new ArrayList<String>();
                    ind_base_ps.add(String.valueOf(item.getIndice_item()+1));
                }

            }
            
            
            requisitos = new Requisitos_busca();
            requisitos.setTipo_folha(tipo_folha);
            requisitos.setCod_rubr(cod_rubr);
            requisitos.setCod_ltc(cod_ltc);
            requisitos.setInd_base_ps(ind_base_ps);
        }

        ArrayList<Relatorio> list_relatorio = C_Relatorios.Buscar_relatorio(periodo_inicial, periodo_final, /*Check_13.isSelected()*/ false, requisitos);
        if(list_relatorio == null)
        list_erros.add("Nenhum registro foi localizado");
        else{
            if(j_relatorio!=null){
                j_relatorio.dispose();
            }
            //Reescrevendo a lista de requisitos de forma formal

            if(list_itens.size()>0){
                ArrayList<String> tipo_folha = null;
                ArrayList<String> cod_rubr = null;
                ArrayList<String> cod_ltc = null;
                ArrayList<String> ind_base_ps = null;

                if(list_rubrica != null)
                    for(Rubrica_apuraçao item:list_rubrica){
                        if(cod_rubr == null)
                                cod_rubr = new ArrayList<String>();
                        cod_rubr.add(item.getCod());               
                    }
                
                for(Item_pesquisa item : list_itens){
                    if(item.getTipo_item()==0){
                        if(tipo_folha == null)
                        tipo_folha = new ArrayList<String>();
                        tipo_folha.add(item.getNome_item());
                    }
                    else if(item.getTipo_item()==2){
                        if(cod_ltc == null)
                        cod_ltc = new ArrayList<String>();
                        cod_ltc.add(item.getNome_item());
                    }
                    else if(item.getTipo_item()==3){
                        if(ind_base_ps == null)
                        ind_base_ps = new ArrayList<String>();
                        ind_base_ps.add(item.getNome_item());
                    }

                }
                
                requisitos = new Requisitos_busca();
                requisitos.setTipo_folha(tipo_folha);
                requisitos.setCod_rubr(cod_rubr);
                requisitos.setCod_ltc(cod_ltc);
                requisitos.setInd_base_ps(ind_base_ps);
            }
            else{
                requisitos = null;
            }
            SimpleDateFormat formato_periodo = new SimpleDateFormat("MM/yyyy"); 
            String text_periodo = "Meses Referentes a Pesquisa: " + formato_periodo.format(periodo_inicial) + " a " + formato_periodo.format(periodo_final); 

            j_relatorio = new J_Relatorio(text_periodo, requisitos, list_relatorio, this);
            j_relatorio.setVisible(true);
            this.setVisible(false);
        }

        for(String erro: list_erros)
        Label_Erro.setText(Label_Erro.getText() + "/ " + erro);
        
    }//GEN-LAST:event_B_BuscarActionPerformed

    private void B_Realizar_apuraçaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Realizar_apuraçaoActionPerformed
        if(list_rubrica != null){
            ArrayList<String> cod_rubr = null;
            
            for(Rubrica_apuraçao item:list_rubrica){
                if(cod_rubr == null)
                        cod_rubr = new ArrayList<String>();
                cod_rubr.add(item.getCod());               
            }
       
            if(cod_rubr != null){
                ArrayList<ArrayList<Apuraçao>> list_rubricas_apuradas = C_Apuraçao.Buscar_rubricas_para_apuraçao(cod_rubr);
                J_Apuraçao_relatorio j_apuraçao = new J_Apuraçao_relatorio(this, list_rubricas_apuradas, list_rubrica);
                j_apuraçao.setVisible(true);
                this.setVisible(false);
                Progressbar.setValue(100);
            }
            else{
                Label_Erro.setText("Nenhuma Rubrica selecionada para a apuração.");
            }
        } 
        else{
                Label_Erro.setText("Nenhuma Rubrica selecionada para a apuração.");
        }
        
    }//GEN-LAST:event_B_Realizar_apuraçaoActionPerformed

    private void B_Atualizar_selicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Atualizar_selicActionPerformed
              
        J_Visualizar_selic j_atualizar_selic = new J_Visualizar_selic(this);
        j_atualizar_selic.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_B_Atualizar_selicActionPerformed

    private void B_Criar_folha_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Criar_folha_pagamentoActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja criar a folha de pagamento?", "", JOptionPane.YES_NO_OPTION);
        
        Runnable ativar = new Runnable() {
            public void run() {
                Progressbar.setIndeterminate(true);
                Label_Erro.setText("Escrevendo Folha de Pagamento...");
                Label_Erro.setVisible(true);
            }
        };  
        Runnable escrever_folha = new Runnable() {
            public void run() {
                String endereço = "Folha_Pagamento/Teste.pdf";
                C_Pdf.Escrever_folha_pagamento(C_Folha_pagamento.Montar_folha(), endereço);

                try {
                    Desktop.getDesktop().open(new File(endereço));
                } catch (IOException ex) {
                    Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
                }     
                Progressbar.setIndeterminate(false);
                Progressbar.setValue(100);
                Label_Erro.setText("Folha de Pagamento foi inserida no diretório Folha_Pagamento/Teste.pdf");
            }
        };  
        
        if(resposta == 0){
            Progressbar.setValue(0);
            new Thread(ativar).start();
            new Thread(escrever_folha).start();
        }
    }//GEN-LAST:event_B_Criar_folha_pagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(J_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(J_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(J_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(J_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new J_Inicial().setVisible(true);
            }
        });
    }

    public void setList_rubrica(ArrayList<Rubrica_apuraçao> list_rubrica) {
        
        if(this.list_rubrica != null)
            for(Rubrica_apuraçao item : this.list_rubrica){
                int i = 0;
                for(Item_pesquisa item_aux:list_itens){
                    if(item_aux.getTipo_item() == 1)
                        if(item_aux.getIndice_item() == Integer.parseInt(item.getCod())){
                            list_itens.remove(i);
                            list_itens_modelo.remove(i);
                            break;
                        }                        
                    i++;
                }  
            }
        
        if(list_rubrica != null){
            this.list_rubrica = list_rubrica;
        
            for(Rubrica_apuraçao item : list_rubrica){

                Item_pesquisa item_pesquisa = new Item_pesquisa();
                item_pesquisa.setNome_tipo("RUBR: ");
                item_pesquisa.setNome_item(item.getCod() + " - " + item.getRubrica());
                item_pesquisa.setTipo_item(1);
                item_pesquisa.setIndice_item(Integer.parseInt(item.getCod()));

                boolean existente = false;
                for(Item_pesquisa item_aux:list_itens)
                    if(item_aux.getTipo_item() == item_pesquisa.getTipo_item())
                        if(item_aux.getIndice_item() == item_pesquisa.getIndice_item())
                            existente = true;

                if(!existente){
                    list_itens.add(item_pesquisa);
                    list_itens_modelo.addElement(item_pesquisa.getNome_tipo() + item_pesquisa.getNome_item());
                }
            }
        }
       
    }

    public String getDados_empresa() {
        return Dados_empresa;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Add_folha;
    private javax.swing.JButton B_Add_ltc;
    private javax.swing.JButton B_Add_ps;
    private javax.swing.JButton B_Armazenar_manad;
    private javax.swing.JButton B_Atualizar_selic;
    private javax.swing.JButton B_Buscar;
    private javax.swing.JButton B_Criar_folha_pagamento;
    private javax.swing.JButton B_Limpar;
    private javax.swing.JButton B_Listar_rubrica;
    private javax.swing.JButton B_Realizar_apuraçao;
    private javax.swing.JButton B_Remover;
    private javax.swing.JComboBox<String> Combo_Ano_final;
    private javax.swing.JComboBox<String> Combo_Ano_inicial;
    private javax.swing.JComboBox<String> Combo_Ind_base_ps;
    private javax.swing.JComboBox<String> Combo_Indicador_folha;
    private javax.swing.JComboBox<String> Combo_Lotaçao;
    private javax.swing.JComboBox<String> Combo_Mes_final;
    private javax.swing.JComboBox<String> Combo_Mes_inicial;
    private javax.swing.JLabel Label_Erro;
    private javax.swing.JLabel Label_Nome_empresa;
    private javax.swing.JLabel Label_Nome_empresa1;
    private javax.swing.JList<String> List_Itens_busca;
    private javax.swing.JPanel Painel_Armazenar;
    private javax.swing.JPanel Painel_Busca;
    private javax.swing.JProgressBar Progressbar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables


}
