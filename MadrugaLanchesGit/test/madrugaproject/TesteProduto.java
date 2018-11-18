/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import model.dao.ProdutoDAO;
import model.entidades.Produto;

/**
 *
 * @author rumen
 */
public class TesteProduto {
    public static void main(String[] args) {
        // TODO code application logic here
        Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();
        
        //p.setCodigo(10);
        //pd.removerPorChave(p.getClass(), p.getChave());
        
        p.setDescricao("Recheio de pitu");
        p.setNome("COXINHA DE pitu");
        p.setPreco(3.00);
        pd.inserir(p);
        System.out.println("insert");
        p.setNome("Coxinha de mario");
        pd.alterarPorObjeto(p);
        System.out.println("alter");
        pd.removerPorObjeto(p);
        System.out.println("delete");
    }
}
