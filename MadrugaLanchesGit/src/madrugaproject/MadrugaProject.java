/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import java.time.Clock;
import model.dao.ProdutoDAO;
import model.entidades.Produto;

/**
 *
 * @author rumen
 */
public class MadrugaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();
        
        p.setDescricao("PÃO, SALCICHA E MOLHO");
        p.setNome("CACHORRO QUENTE");
        p.setPreco(3.50);
        
        pd.inserir(p);
        
        System.out.println("funcionou");
    }
    
}
