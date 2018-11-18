/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import model.dao.*;
import model.entidades.Endereco;


/**
 *
 * @author rumenik.andrade
 */
public class TesteEndereco {
    public static void main(String [] args){
        EnderecoDAO eDAO = new EnderecoDAO();
        Endereco e = new Endereco(51330270,"IBURA","CASA", 35, "Esquina com a Rua 24");
        eDAO.inserir(e);
        System.out.println("insert");
    
        e.setReferencia("Esquina entre a rua 24 e a Av Tiradentes");
        eDAO.alterarPorObjeto(e);
        System.out.println("alter");
        //eDAO.removerPorObjeto(e);
        //System.out.println("delete");
    }
}
