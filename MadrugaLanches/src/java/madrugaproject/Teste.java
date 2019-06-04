/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import model.dao.*;
import model.entidades.Cliente;
import model.entidades.Produto;

/**
 *
 * @author Igor
 */
public class Teste {
    public static void main(String[] args) {
        /*Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();     
        p.setNome("COXINHA DE MARIO");
        pd.inserir(p);
        System.out.println("insert");
        //p.setNome("Coxinha de mario");
        System.out.println("alter");
*/
        Cliente c = new Cliente();
        ClienteDAO cd = new ClienteDAO();     
        c.setNome("COXINHA DE MARIO");
        cd.inserir(c);
        System.out.println("insert");
        //p.setNome("Coxinha de mario");
        System.out.println("alter");
    }
}
