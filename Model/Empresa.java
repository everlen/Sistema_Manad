/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Everlen
 */
public class Empresa {
    String Nome;
    ArrayList<String> CNPJ;
    Date inicio;
    Date fim;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<String> getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(ArrayList<String> CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
    
    
}
