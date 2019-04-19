/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Victony
 */
public class Folha_pagamento {
    
    String dt_comp;
    String periodo;
    ArrayList<Item_folha_pagamento> list_item_folha;
    Item_folha_pagamento totalizaçao;

    public String getDt_comp() {
        return dt_comp;
    }

    public void setDt_comp(String dt_comp) {
        this.dt_comp = dt_comp;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public ArrayList<Item_folha_pagamento> getList_item_folha() {
        return list_item_folha;
    }

    public void setList_item_folha(ArrayList<Item_folha_pagamento> list_item_folha) {
        this.list_item_folha = list_item_folha;
    }

    public Item_folha_pagamento getTotalizaçao() {
        return totalizaçao;
    }

    public void setTotalizaçao(Item_folha_pagamento totalizaçao) {
        this.totalizaçao = totalizaçao;
    }
    
    
    
}
