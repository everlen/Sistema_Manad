/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Apuraçao;
import Model.Folha_pagamento;
import Model.Item_folha_pagamento;
import Model.Rubr_folha_pagamento;
import Model.Rubrica_apuraçao;
import Model.Selic;
import View.J_Apuraçao_relatorio;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victony
 */
public class C_Pdf {
    
    ArrayList<Apuraçao> list_apuraçao_resumo;
    ArrayList<Apuraçao> list_apuraçao_anual;
    ArrayList<Apuraçao> list_apuraçao_mensal;
    
    public void Escrever_relatorio_apuraçao(ArrayList<Apuraçao> list_tabela_resumo, ArrayList<Apuraçao> list_tabela_anual, ArrayList<Apuraçao> list_tabela_mensal, String nome_empresa, float empresa, float rat, float terceiro, int mes_inicial, int ano_inicial, int mes_final, int ano_final, ArrayList<Rubrica_apuraçao> list_rubricas_selecionadas, ArrayList<Selic> list_selic_tratada){
        list_apuraçao_resumo = list_tabela_resumo;
        list_apuraçao_anual = list_tabela_anual;
        list_apuraçao_mensal = list_tabela_mensal;   
        Document documento = null;
        String endereço;
        PdfCopyFields documento_final = null;
                
        try {
            endereço = "Apuraçao/" + nome_empresa + ".pdf";
            File buscar_existencia = new File(endereço);
            if(buscar_existencia != null)
                buscar_existencia.delete();
            
            documento_final = new PdfCopyFields(new FileOutputStream(endereço));      
            File documento_inutil = null;
                      
            
            endereço = "Apuraçao/" + nome_empresa + "_Evento.pdf";
            Escrever_tabela_rubr(documento, endereço, list_rubricas_selecionadas, C_Apuraçao.Buscar_todos_item_apuraçao());
            PdfReader pdf_rubrica = new PdfReader(endereço);
            documento_final.addDocument(pdf_rubrica);
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            endereço = "Apuraçao/" + nome_empresa + "_Incidencia.pdf";
            Escrever_tabela_incidencia(mes_inicial, ano_inicial, mes_final, ano_final, empresa, rat, terceiro, documento, endereço);
            PdfReader pdf_incidencia = new PdfReader(endereço);
            documento_final.addDocument(pdf_incidencia);           
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            endereço = "Apuraçao/" + nome_empresa + "_Selic.pdf";
            list_selic_tratada = C_Selic.Organizar_lista_PDF(list_selic_tratada);
            Escrever_tabela_selic(documento, endereço, ano_inicial, ano_final, mes_inicial, mes_final, list_selic_tratada);
            PdfReader pdf_selic = new PdfReader(endereço);
            documento_final.addDocument(pdf_selic);           
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            endereço = "Apuraçao/" + nome_empresa + "_Resumo.pdf";
            Escrever_tabela_resumo(documento, endereço);
            PdfReader pdf_resumo = new PdfReader(endereço);
            documento_final.addDocument(pdf_resumo);
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            endereço = "Apuraçao/" + nome_empresa + "_Anual.pdf";
            Escrever_tabela_anual(documento, endereço);
            PdfReader pdf_anual = new PdfReader(endereço);
            documento_final.addDocument(pdf_anual);           
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            endereço = "Apuraçao/" + nome_empresa + "_Mensal.pdf";
            Escrever_tabela_mensal(documento, endereço);
            PdfReader pdf_mensal = new PdfReader(endereço);
            documento_final.addDocument(pdf_mensal);           
            documento_inutil = new File(endereço);
            documento_inutil.delete();
            
            documento_final.close();
            pdf_resumo.close();
            pdf_anual.close();
            pdf_mensal.close();
            
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Escrever_tabela_resumo(Document documento_resumo, String endereço){
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_subtitulo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_total = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        
        try {
            
            PdfPTable tabela_resumo = new PdfPTable(5);
            
            PdfPCell cell_titulo = new PdfPCell(new Paragraph("RESUMO DO CRÉDITO APURADO", font_titulo));
            cell_titulo.setColspan(5);
            cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
            tabela_resumo.addCell(cell_titulo);
            
            String[] subtitulos = {"Ano", "Redução da Base de Cálculo", "Incidência Empresa", "Incidência RAT", "Incidência Terceiros"};           
            for( int i = 0; i< subtitulos.length; i++){
                PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulos[i], font_subtitulo));
                cell_subtitulo.setColspan(1);
                cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                tabela_resumo.addCell(cell_subtitulo);
            }

            for(Apuraçao apuraçao : list_apuraçao_resumo){
                PdfPCell cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_conteudo));
                if(apuraçao.getAno().equals("Total")){
                    cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_total));
                    cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                }
                    
                
                cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela_resumo.addCell(cell_apuraçao);
                
                cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getValor_evento()), font_conteudo));
                if(apuraçao.getAno().equals("Total"))
                    cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela_resumo.addCell(cell_apuraçao);
                
                cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getEmpresa_atualizado()), font_conteudo));
                if(apuraçao.getAno().equals("Total"))
                    cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela_resumo.addCell(cell_apuraçao);
                
                cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getRat_atualizado()), font_conteudo));
                if(apuraçao.getAno().equals("Total"))
                    cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela_resumo.addCell(cell_apuraçao);
                
                cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTerceiros_atualizado()), font_conteudo));
                if(apuraçao.getAno().equals("Total"))
                    cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela_resumo.addCell(cell_apuraçao);
                
            }
            tabela_resumo.setTotalWidth(550);
            tabela_resumo.setLockedWidth(true);
            
            documento_resumo = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists()){
                buscar_existencia.delete();
            }              
                
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_resumo, fileoutput);
           
            documento_resumo.open();
            documento_resumo.add(tabela_resumo); 
            documento_resumo.close();
            fileoutput.flush();
            fileoutput.close();
            

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
    }
    
    private void Escrever_tabela_anual(Document documento_anual, String endereço){
        
        Font font_inicio = new Font(FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_subtitulo = new Font(FontFamily.TIMES_ROMAN, 8);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_total = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
       
        try{
            documento_anual = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists())
                buscar_existencia.delete();
                   
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_anual, fileoutput);
            documento_anual.open();
            
            boolean inserir_nova_tabela = true;
            int indice_atual = 0, numero_tabela = 0;
            while(inserir_nova_tabela){
                
                Paragraph titulo = new Paragraph(list_apuraçao_anual.get(indice_atual).getDes_rubr(), font_inicio);
                titulo.setAlignment(Element.ALIGN_CENTER);
                
                
                String[] subtitulos = {"Ano","Código Evento", "Valor Evento", "Incidência Empresa", "Valor Atualizado", "Incidência RAT", "Valor Atualizado", "Incidência Terceiros", "Valor Atualizado", "Total Apurado", "Total Atualizado"};           
                PdfPTable tabela_anual = new PdfPTable(subtitulos.length);
                numero_tabela++;
    //Titulo            
                PdfPCell cell_titulo = new PdfPCell(new Paragraph("Item", font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_anual.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph(String.valueOf(numero_tabela), font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_anual.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph("Resumo", font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_anual.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph(list_apuraçao_anual.get(indice_atual).getDes_rubr(), font_titulo));
                cell_titulo.setColspan(8);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_anual.addCell(cell_titulo);           

    //Subtitulo            
                for( int i = 0; i< subtitulos.length; i++){
                    PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulos[i], font_subtitulo));
                    cell_subtitulo.setRowspan(2);
                    cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                    tabela_anual.addCell(cell_subtitulo);
                }

    //Registros
                for(int i = indice_atual; i<list_apuraçao_anual.size(); i++){
                    Apuraçao apuraçao = list_apuraçao_anual.get(i);
                    
                    PdfPCell cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_conteudo));
                    if(apuraçao.getAno().equals("Total")){
                        inserir_nova_tabela = true;
                        cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_total));
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                        cell_apuraçao.setColspan(2);
                    }
                    else
                        inserir_nova_tabela = false;

                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    if(!inserir_nova_tabela){
                        cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getCod_rubr(), font_conteudo));
                        cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabela_anual.addCell(cell_apuraçao);
                    }
                    
                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getValor_evento()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getEmpresa()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getEmpresa_atualizado()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getRat()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getRat_atualizado()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTerceiros()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTerceiros_atualizado()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTotal_apurado()), font_conteudo));
                    if(inserir_nova_tabela)
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTotal_atualizado()), font_conteudo));
                    if(inserir_nova_tabela){
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                        cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabela_anual.addCell(cell_apuraçao);
                        indice_atual++;
                        break;
                    }
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_anual.addCell(cell_apuraçao);
                    
                    indice_atual++;

                }

                tabela_anual.setTotalWidth(550);
                tabela_anual.setLockedWidth(true);
                documento_anual.add(titulo);
                documento_anual.add(Chunk.NEWLINE);
                documento_anual.add(tabela_anual); 
                if(inserir_nova_tabela)
                    if(indice_atual<list_apuraçao_anual.size())
                        documento_anual.add(Chunk.NEXTPAGE);
                    else
                        inserir_nova_tabela = false;
            }         
            
            documento_anual.close();
            fileoutput.flush();
            fileoutput.close();

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
    }
    
    private void Escrever_tabela_mensal(Document documento_mensal, String endereço){
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_subtitulo = new Font(FontFamily.TIMES_ROMAN, 8);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_total = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
        
        
        
        try{
            documento_mensal = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists())
                buscar_existencia.delete();
                       
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_mensal, fileoutput);
            documento_mensal.open();           

            boolean inserir_nova_tabela = true;
            int indice_atual = 0, quant_tabelas = 0;
            
            while(inserir_nova_tabela){
                
                String[] subtitulos = {"Mês-Ano", "Valor Evento", "Incidência Empresa", "Juros Selic", "Valor Atualizado", "Incidência RAT", "Valor Atualizado", "Incidência Terceiros", "Valor Atualizado", "Total Apurado", "Total Atualizado"};           
                PdfPTable tabela_mensal = new PdfPTable(subtitulos.length);
                quant_tabelas++;
                
//Titulo            

                PdfPCell cell_titulo = new PdfPCell(new Paragraph(" ", font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_mensal.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph("Item " + String.valueOf(quant_tabelas), font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_mensal.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph(list_apuraçao_mensal.get(indice_atual).getCod_rubr(), font_titulo));
                cell_titulo.setColspan(1);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_mensal.addCell(cell_titulo);

                cell_titulo = new PdfPCell(new Paragraph(list_apuraçao_mensal.get(indice_atual).getDes_rubr(), font_titulo));
                cell_titulo.setColspan(8);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_mensal.addCell(cell_titulo);           

    //Subtitulo            
                for( int i = 0; i< subtitulos.length; i++){
                    PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulos[i], font_subtitulo));
                    cell_subtitulo.setRowspan(2);
                    cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                    tabela_mensal.addCell(cell_subtitulo);
                }

    //Registros
                for(int i = indice_atual; i < list_apuraçao_mensal.size(); i++){
                    Apuraçao apuraçao = list_apuraçao_mensal.get(i);
                    
                    
                    PdfPCell cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getMes()+"-"+apuraçao.getAno(), font_conteudo));
                    if(apuraçao.getAno().equals("Total")){
                        inserir_nova_tabela = true;
                        cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_total));
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    }
                    else
                        inserir_nova_tabela = false;
                    
                    if(apuraçao.getAno().equals("Soma")){
                        cell_apuraçao = new PdfPCell(new Paragraph(apuraçao.getAno(), font_total));
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    }
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getValor_evento()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getEmpresa()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getSelic()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getEmpresa_atualizado()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getRat()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);
                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getRat_atualizado()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTerceiros()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);
                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f",apuraçao.getTerceiros_atualizado()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);

                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f", apuraçao.getTotal_apurado()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);
                    cell_apuraçao = new PdfPCell(new Paragraph(String.format("%.2f",apuraçao.getTotal_atualizado()), font_conteudo));
                    if(apuraçao.getAno().equals("Total"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(200, 200, 200));
                    else if(apuraçao.getAno().equals("Soma"))
                        cell_apuraçao.setBackgroundColor(new BaseColor(220, 220, 220)); 
                    cell_apuraçao.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabela_mensal.addCell(cell_apuraçao);
                    
                    indice_atual++;
                    if(inserir_nova_tabela)
                        break;
                }

                tabela_mensal.setTotalWidth(550);
                tabela_mensal.setLockedWidth(true);
                documento_mensal.add(tabela_mensal);  
                
                if(inserir_nova_tabela)
                    if(indice_atual<list_apuraçao_mensal.size())
                        documento_mensal.add(Chunk.NEXTPAGE);
                    else
                        inserir_nova_tabela = false;
            }
                     
            documento_mensal.close();
            fileoutput.flush();
            fileoutput.close();

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
    }
    
    public static void Escrever_tabela_rubr(Document documento_rubrica, String endereço, ArrayList<Rubrica_apuraçao> list_rubricas_selecionadas, ArrayList<Rubrica_apuraçao> list_todas_rubricas){
        
        for(int i = 0; i< list_todas_rubricas.size()-1; i++){
            for(int c = i+1; c< list_todas_rubricas.size(); c++){               
                if(Integer.parseInt(list_todas_rubricas.get(i).getCod()) > Integer.parseInt(list_todas_rubricas.get(c).getCod())){
                    Rubrica_apuraçao rubr_aux = list_todas_rubricas.get(i);
                    list_todas_rubricas.set(i, list_todas_rubricas.get(c));
                    list_todas_rubricas.set(c, rubr_aux);
                }               
            }
        }
        
//Inicio escrita PDF 
        
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_subtitulo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_total = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        
        try {
            
            PdfPTable tabela_resumo = new PdfPTable(7);
            
            PdfPCell cell_titulo = new PdfPCell(new Paragraph("INCIDENCIA", font_titulo));
            cell_titulo.setColspan(7);
            cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
            tabela_resumo.addCell(cell_titulo);
            
            String[] subtitulos = {"Cod", "Rubrica", "INSS"};           
            for( int i = 0; i< subtitulos.length; i++){
                PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulos[i], font_subtitulo));
                if(subtitulos[i].equals("Rubrica"))
                    cell_subtitulo.setColspan(5);
                else
                    cell_subtitulo.setColspan(1);
                
                cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                tabela_resumo.addCell(cell_subtitulo);
            }

            for(Rubrica_apuraçao rubr: list_todas_rubricas){
                
                PdfPCell cell_rubr = new PdfPCell(new Paragraph(rubr.getCod(), font_conteudo));
                cell_rubr.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_rubr.setColspan(1);
                tabela_resumo.addCell(cell_rubr);
                
                cell_rubr = new PdfPCell(new Paragraph(rubr.getRubrica(), font_conteudo));
                cell_rubr.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_rubr.setColspan(5);
                tabela_resumo.addCell(cell_rubr);
                
                String inss = "N";
                if(rubr.getInss() == 1)
                    inss = "S";
                cell_rubr = new PdfPCell(new Paragraph(inss, font_conteudo));
                cell_rubr.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_rubr.setColspan(1);
                tabela_resumo.addCell(cell_rubr);
                
            }
            tabela_resumo.setTotalWidth(350);
            tabela_resumo.setLockedWidth(true);
            
            documento_rubrica = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists()){
                buscar_existencia.delete();
            }              
                
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_rubrica, fileoutput);
           
            documento_rubrica.open();
            documento_rubrica.add(tabela_resumo); 
            documento_rubrica.close();
            fileoutput.flush();
            fileoutput.close();
            

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
        
        
    }
    
    public static void Escrever_tabela_selic(Document documento_selic, String endereço, int ano_inicial, int ano_final, int mes_inicial, int mes_final, ArrayList<Selic> list_selic_tratada){
        
//Inicio escrita PDF 
        
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_subtitulo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        try {
            
//Tameanho tabela e subtitulo
            ArrayList<String> subtitulo = new ArrayList<String>();
            subtitulo.add("Mês/Ano");
            for(int i = ano_inicial; i <= ano_final; i++){              
                subtitulo.add(String.valueOf(i));               
            }     
  
//Titulo           
            PdfPTable tabela_selic = new PdfPTable(subtitulo.size());
            
            PdfPCell cell_titulo = new PdfPCell(new Paragraph("Taxa Selic Acumulada", font_titulo));
            cell_titulo.setColspan(subtitulo.size());
            cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
            tabela_selic.addCell(cell_titulo);
 //Subtitulo           
            for( int i = 0; i< subtitulo.size(); i++){
                PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulo.get(i), font_subtitulo));
                cell_subtitulo.setColspan(1);
                cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                tabela_selic.addCell(cell_subtitulo);
            }
 

//Conteudo
            String mes = "Janeiro";
            int indice = 0;
            for(int i = 1; i <= 12; i++){

                PdfPCell cell_conteudo = new PdfPCell(new Paragraph(mes, font_conteudo));
                cell_conteudo.setColspan(1);
                cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_conteudo.setBackgroundColor(new BaseColor(200, 200, 200));
                tabela_selic.addCell(cell_conteudo);

                for(int c = ano_inicial; c <= ano_final; c++){

                    if((i < mes_inicial && c == ano_inicial) || (i > mes_final && c == ano_final)){
                        cell_conteudo = new PdfPCell(new Paragraph("-", font_conteudo));
                        cell_conteudo.setColspan(1);
                        cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabela_selic.addCell(cell_conteudo);
                    }
                    else{
                        cell_conteudo = new PdfPCell(new Paragraph(df.format(list_selic_tratada.get(indice).getPorcentagem()), font_conteudo));
                        cell_conteudo.setColspan(1);
                        cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabela_selic.addCell(cell_conteudo);
                        indice++;
                    }


                }
                if(i == 1)
                    mes = "Fevereiro";
                else if(i == 2)
                    mes = "Março";
                else if(i == 3)
                    mes = "Abril";
                else if(i == 4)
                    mes = "Maio";
                else if(i == 5)
                    mes = "Junho";
                else if(i == 6)
                    mes = "Julho";
                else if(i == 7)
                    mes = "Agosto";
                else if(i == 8)
                    mes = "Setembro";
                else if(i == 9)
                    mes = "Outubro";
                else if(i == 10)
                    mes = "Novembro";
                else if(i == 11)
                    mes = "Dezembro";            

            }    
                
            tabela_selic.setTotalWidth(400);
            tabela_selic.setLockedWidth(true);
            
            documento_selic = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists()){
                buscar_existencia.delete();
            }              
                
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_selic, fileoutput);
           
            documento_selic.open();
            documento_selic.add(tabela_selic); 
            documento_selic.close();
            fileoutput.flush();
            fileoutput.close();
            

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
        
        
    }
    
    public static void Escrever_tabela_incidencia(int mes_inicial, int ano_inicial, int mes_final, int ano_final, float empresa, float rat, float terceiro, Document documento_incidencia, String endereço){
             
        Font font_inicio = new Font(FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_data = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        
        try {
            PdfPTable tabela_empresa = null, tabela_rat = null, tabela_terceiro = null;
            
            Paragraph titulo = new Paragraph("Tabela de Incidências", font_inicio);
            titulo.setAlignment(Element.ALIGN_LEFT);
   

            for(int quant_tabela = 0; quant_tabela < 3; quant_tabela++){
 //Titulo
                float valor;
                String titulo_tabela = "";
                if(quant_tabela == 0){
                     valor = empresa;
                     titulo_tabela = "Percentual de Incidência Patronal";
                }                   
                else if(quant_tabela == 1){
                    valor = rat;  
                    titulo_tabela = "Percentual de Incidência RAT";
                }                    
                else{
                    valor = terceiro;   
                    titulo_tabela = "Percentual de Incidência Terceiros";
                }
                    

                PdfPTable tabela_incidencia = new PdfPTable(ano_final - ano_inicial+2);

                PdfPCell cell_titulo = new PdfPCell(new Paragraph(titulo_tabela, font_titulo));               
                cell_titulo.setColspan(ano_final - ano_inicial+2);
                cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell_titulo.setBackgroundColor(new BaseColor(150, 150, 150));           
                tabela_incidencia.addCell(cell_titulo);

    //Subtitulo
                ArrayList<String> subtitulo = new ArrayList<String>();
                subtitulo.add("Mês/Ano");
                for(int i = ano_inicial; i<= ano_final; i++){              
                    subtitulo.add(String.valueOf(i));               
                }        
                for( int i = 0; i< subtitulo.size(); i++){
                    PdfPCell cell_subtitulo = new PdfPCell(new Paragraph(subtitulo.get(i), font_data));
                    cell_subtitulo.setColspan(1);
                    cell_subtitulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell_subtitulo.setBackgroundColor(new BaseColor(200, 200, 200));
                    tabela_incidencia.addCell(cell_subtitulo);
                }

    //Conteudo
                String mes = "Janeiro";
                for(int i = 1; i <= 12; i++){

                    PdfPCell cell_conteudo = new PdfPCell(new Paragraph(mes, font_conteudo));
                    cell_conteudo.setColspan(1);
                    cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell_conteudo.setBackgroundColor(new BaseColor(200, 200, 200));
                    tabela_incidencia.addCell(cell_conteudo);

                    for(int c = ano_inicial; c <= ano_final; c++){

                        if((i < mes_inicial && c == ano_inicial) || (i > mes_final && c == ano_final)){
                            cell_conteudo = new PdfPCell(new Paragraph("-", font_conteudo));
                            cell_conteudo.setColspan(1);
                            cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabela_incidencia.addCell(cell_conteudo);
                        }
                        else{
                            cell_conteudo = new PdfPCell(new Paragraph(String.valueOf(valor), font_conteudo));
                            cell_conteudo.setColspan(1);
                            cell_conteudo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabela_incidencia.addCell(cell_conteudo);
                        }


                    }
                    if(i == 1)
                        mes = "Fevereiro";
                    else if(i == 2)
                        mes = "Março";
                    else if(i == 3)
                        mes = "Abril";
                    else if(i == 4)
                        mes = "Maio";
                    else if(i == 5)
                        mes = "Junho";
                    else if(i == 6)
                        mes = "Julho";
                    else if(i == 7)
                        mes = "Agosto";
                    else if(i == 8)
                        mes = "Setembro";
                    else if(i == 9)
                        mes = "Outubro";
                    else if(i == 10)
                        mes = "Novembro";
                    else if(i == 11)
                        mes = "Dezembro";            

                }    

                tabela_incidencia.setTotalWidth(400);
                tabela_incidencia.setLockedWidth(true);
                
                if(quant_tabela == 0)
                    tabela_empresa = tabela_incidencia;
                else if(quant_tabela == 1)
                    tabela_rat = tabela_incidencia;
                else
                    tabela_terceiro = tabela_incidencia;
            }
            
            documento_incidencia = new Document();
            File buscar_existencia = new File(endereço);
            if(buscar_existencia.exists()){
                buscar_existencia.delete();
            }              
                
            OutputStream fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_incidencia, fileoutput);
           
            documento_incidencia.open();
            documento_incidencia.add(titulo);
            documento_incidencia.add(Chunk.NEWLINE);
            if(tabela_empresa != null)
                documento_incidencia.add(tabela_empresa); 
            else{
                documento_incidencia.add(new Paragraph("Erro com a incidencia Patronal"));
            }
            documento_incidencia.add(Chunk.NEWLINE);
            if(tabela_rat != null)
                documento_incidencia.add(tabela_rat);  
            else{
                 documento_incidencia.add(new Paragraph("Erro com a incidencia RAT"));
            }
            documento_incidencia.add(Chunk.NEWLINE);
            if(tabela_terceiro != null)
                documento_incidencia.add(tabela_terceiro); 
            else{
                 documento_incidencia.add(new Paragraph("Erro com a incidencia Terceiros"));
            }
            
            documento_incidencia.close();
            fileoutput.flush();
            fileoutput.close();
            

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return;
        
    }
    
    public static void Escrever_folha_pagamento(ArrayList<Folha_pagamento> list_folha_pagamento, String endereço){
        Document documento_folha = new Document();
        File buscar_existencia = new File(endereço);
        if(buscar_existencia.exists())
            buscar_existencia.delete();
        
        OutputStream fileoutput = null;
        try {
            fileoutput = new FileOutputStream(endereço);
            PdfWriter.getInstance(documento_folha, fileoutput);
            documento_folha.open();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        Font font_titulo = new Font(FontFamily.TIMES_ROMAN, 12);
        Font font_nome_trab = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
        Font font_conteudo = new Font(FontFamily.TIMES_ROMAN, 10);
        Font font_conteudo_estreito = new Font(FontFamily.TIMES_ROMAN, 10);
            
        for(Folha_pagamento folha_dtcomp : list_folha_pagamento){

            PdfPTable tabela_folha_dt_comp = new PdfPTable(12);        
            tabela_folha_dt_comp.setTotalWidth(550);
            tabela_folha_dt_comp.setLockedWidth(true);


//Titulo DT_COMP                
            PdfPCell cell_titulo = new PdfPCell(new Paragraph("Mes de Referente: "+folha_dtcomp.getDt_comp(), font_titulo));
            cell_titulo.setColspan(12);
            cell_titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell_titulo.setBackgroundColor(new BaseColor(200, 200, 200));           
            tabela_folha_dt_comp.addCell(cell_titulo);
            
//Subtitulos                
            PdfPCell cell_subtitulo = new PdfPCell(new Paragraph("TRABALHADORES", font_titulo));
            cell_subtitulo.setColspan(3);
            cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);    
            tabela_folha_dt_comp.addCell(cell_subtitulo);

            cell_subtitulo = new PdfPCell(new Paragraph("PROVENTOS", font_titulo));
            cell_subtitulo.setColspan(5);
            cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);       
            tabela_folha_dt_comp.addCell(cell_subtitulo);

            cell_subtitulo = new PdfPCell(new Paragraph("DESCONTOS", font_titulo));
            cell_subtitulo.setColspan(4);
            cell_subtitulo.setHorizontalAlignment(Element.ALIGN_CENTER);       
            tabela_folha_dt_comp.addCell(cell_subtitulo);


            for(Item_folha_pagamento item_folha : folha_dtcomp.getList_item_folha()){
               
                ArrayList<ArrayList<PdfPCell>> list_cell_provento = new ArrayList<ArrayList<PdfPCell>>();
                ArrayList<ArrayList<PdfPCell>> list_cell_desconto = new ArrayList<ArrayList<PdfPCell>>();

//Pre montagem das listas de proventos e descontos                
                PdfPCell cell_conteudo;
                for(Rubr_folha_pagamento rubr : item_folha.getList_rubr()){
                    
                    ArrayList<PdfPCell> list_item_rubr = new ArrayList<PdfPCell>();
                    
                    cell_conteudo = new PdfPCell(new Paragraph(rubr.getCod(), font_conteudo));
                    cell_conteudo.setColspan(1);
                    cell_conteudo.setHorizontalAlignment(Element.ALIGN_RIGHT); 
                    list_item_rubr.add(cell_conteudo);
                    
                    cell_conteudo = new PdfPCell(new Paragraph(rubr.getDescriçao(), font_conteudo));
                    cell_conteudo.setColspan(2);
                    cell_conteudo.setHorizontalAlignment(Element.ALIGN_LEFT); 
                    list_item_rubr.add(cell_conteudo);
                    
                    if(rubr.getInd_rubr() == 'P'){   
                        
                        cell_conteudo = new PdfPCell(new Paragraph("?", font_conteudo));
                        cell_conteudo.setColspan(1);
                        cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER); 
                        list_item_rubr.add(cell_conteudo);     
                        
                        list_cell_provento.add(list_item_rubr);
                    }
                    else{
                        list_cell_desconto.add(list_item_rubr);
                    }
                    
                    cell_conteudo = new PdfPCell(new Paragraph(String.valueOf(rubr.getValor()), font_conteudo));
                    cell_conteudo.setColspan(1);
                    cell_conteudo.setHorizontalAlignment(Element.ALIGN_CENTER); 
                    list_item_rubr.add(cell_conteudo);
                }
//fim da pre montagem

                 
//Inicio do item folha   
                PdfPCell cell_info_item;
                PdfPCell cell_nome_trab = new PdfPCell(new Paragraph(item_folha.getNome_trabalhado(), font_nome_trab));
                cell_nome_trab.setColspan(3);
                tabela_folha_dt_comp.addCell(cell_nome_trab);
 

                int indice_cell_p_d = 0;
//provento                
                if(list_cell_provento.size()> indice_cell_p_d)
                    for(PdfPCell cell_provento : list_cell_provento.get(indice_cell_p_d)){
                      //cell_provento.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_provento);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(5);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
//Desconto
                if(list_cell_desconto.size() > indice_cell_p_d)
                    for(PdfPCell cell_desconto : list_cell_desconto.get(indice_cell_p_d)){
                        //cell_desconto.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_desconto);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(4);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
                
                indice_cell_p_d++;
//Fim linha 1    
                int quant_linhas_ocupara = 7;
                if(item_folha.Contabilizar_quant_linhas() > quant_linhas_ocupara)
                     quant_linhas_ocupara = item_folha.Contabilizar_quant_linhas();
                
                
                cell_info_item = new PdfPCell(new Paragraph(item_folha.getDesc_cargo(), font_conteudo));
                cell_info_item.setColspan(2);
                tabela_folha_dt_comp.addCell(cell_info_item);
                cell_info_item = new PdfPCell(new Paragraph("?", font_conteudo));
                cell_info_item.setColspan(1);
                tabela_folha_dt_comp.addCell(cell_info_item);
                
//provento                
                if(list_cell_provento.size()> indice_cell_p_d)
                    for(PdfPCell cell_provento : list_cell_provento.get(indice_cell_p_d)){
                      //cell_provento.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_provento);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(5);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
//Desconto
                if(list_cell_desconto.size() > indice_cell_p_d)
                    for(PdfPCell cell_desconto : list_cell_desconto.get(indice_cell_p_d)){
                        //cell_desconto.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_desconto);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(4);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
                indice_cell_p_d++;
//Fim linha 2    
                
                cell_info_item = new PdfPCell(new Paragraph("Admissão em " + item_folha.getDt_admissao(), font_conteudo_estreito));
                cell_info_item.setColspan(3);
                tabela_folha_dt_comp.addCell(cell_info_item);
                
//provento                
                if(list_cell_provento.size()> indice_cell_p_d)
                    for(PdfPCell cell_provento : list_cell_provento.get(indice_cell_p_d)){
                      //cell_provento.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_provento);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(5);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
//Desconto
                if(list_cell_desconto.size() > indice_cell_p_d)
                    for(PdfPCell cell_desconto : list_cell_desconto.get(indice_cell_p_d)){
                        //cell_desconto.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_desconto);
                    }
                else{
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(4);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);
                }
                
                indice_cell_p_d++;
//Fim linha 3                   
//Esvazia fila de proventos e descontos

                while(list_cell_provento.size()> indice_cell_p_d || list_cell_desconto.size() > indice_cell_p_d){
                    cell_info_item = new PdfPCell(new Paragraph(""));
                    cell_info_item.setColspan(3);
                    cell_info_item.setBorder(Rectangle.NO_BORDER);
                    tabela_folha_dt_comp.addCell(cell_info_item);

//provento                
                    if(list_cell_provento.size()> indice_cell_p_d)
                        for(PdfPCell cell_provento : list_cell_provento.get(indice_cell_p_d)){
                          //cell_provento.setBorder(Rectangle.NO_BORDER);
                            tabela_folha_dt_comp.addCell(cell_provento);
                        }
                    else{
                        cell_info_item = new PdfPCell(new Paragraph(""));
                        cell_info_item.setColspan(5);
                        cell_info_item.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_info_item);
                    }
//Desconto
                    if(list_cell_desconto.size() > indice_cell_p_d)
                        for(PdfPCell cell_desconto : list_cell_desconto.get(indice_cell_p_d)){
                            //cell_desconto.setBorder(Rectangle.NO_BORDER);
                            tabela_folha_dt_comp.addCell(cell_desconto);
                        }
                    else{
                        cell_info_item = new PdfPCell(new Paragraph(""));
                        cell_info_item.setColspan(4);
                        cell_info_item.setBorder(Rectangle.NO_BORDER);
                        tabela_folha_dt_comp.addCell(cell_info_item);
                    }

                    indice_cell_p_d++;
                }
//Finalização Rubricas
                
                cell_info_item = new PdfPCell(new Paragraph("-"));
                cell_info_item.setColspan(12);
                cell_info_item.setBorder(Rectangle.NO_BORDER);
                cell_info_item.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell_info_item.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tabela_folha_dt_comp.addCell(cell_info_item);
            }
//Totalização

            try {
 
                documento_folha.add(tabela_folha_dt_comp);
                documento_folha.add(Chunk.NEXTPAGE);
            } catch (DocumentException ex) {
                Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
            }

        }          


// Finalização do documento            




        documento_folha.close();
        try {
            if(fileoutput !=null){
                fileoutput.flush();        
                fileoutput.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(C_Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
}
