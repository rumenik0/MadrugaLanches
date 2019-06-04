/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import model.dao.*;
import model.entidades.*;

/**
 *
 * @author rumen
 */
public class TesteProduto {
    public static void main(String[] args) {
        // TODO code application logic here
       /* Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();     
        p.setNome("COXINHA DE MARIO");
        pd.inserir(p);
        System.out.println("insert");
        */
        /*
        Cliente c = new Cliente();
        
        ClienteDAO cd = new ClienteDAO();     
        
        c.setNome("COXINHA DE MARIO");
        c.setTelefone("83364130");
        c.setDataInicio("01/02/1997");
        c.setEndereco(null);
        cd.inserir(c);
        System.out.println("insert");
        */
         // TODO code application logic here
        Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();     
        p.setNome("COXINHA DE MARIO");
        p.setCodigo(8);
        //pd.inserir(p);
        System.out.println("insert");
        //p.setNome("Coxinha de mario");
        pd.removerPorObjeto(p);     
        System.out.println("alter");
    }
}
