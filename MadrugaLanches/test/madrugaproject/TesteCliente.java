/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.entidades.Cliente;
import model.entidades.Endereco;

/**
 *
 * @author rumenik.andrade
 */
public class TesteCliente {
    public static void main(String[] args) {
        EnderecoDAO endDAO = new EnderecoDAO();
        Endereco end = new Endereco();
        end = (new Endereco(51330260,"IBURA","CASA", 66, "Rua 25, perto do canal"));
        Cliente e = new Cliente(end,"Rumenik Andrade","979146365","123");
        ClienteDAO eDAO = new ClienteDAO();
        eDAO.inserir(e);
        System.out.println("insert");
        e.setNome("Rumenik de Andrade Cabral");
        eDAO.alterarPorObjeto(e);
        System.out.println("FIM");
        //eDAO.removerPorObjeto(e);
        //System.out.println("delete");
        //e.setCodigo(10);
        //eDAO.removerPorChave(e.getClass(), e.getChave());
        
    }
}
