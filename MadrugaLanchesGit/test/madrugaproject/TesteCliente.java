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
        ArrayList<Endereco> end = new ArrayList<Endereco>();
        end.add(new Endereco(51330260,"CASA", 66, "Rua 25, perto do canal"));
        for (Endereco i :end){
            endDAO.inserir(i);
            System.out.println("insert endereco");
        }
        Date dt = new Date(System.currentTimeMillis());
        Cliente e = new Cliente(dt,end,"Rumenik Andrade","81996908623");
        ClienteDAO eDAO = new ClienteDAO();
        eDAO.inserir(e);
        System.out.println("insert");
        e.setNome("Rumenik de Andrade Cabral");
        eDAO.alterarPorObjeto(e);
        System.out.println("alter");
        //eDAO.removerPorObjeto(e);
        //System.out.println("delete");
        //e.setCodigo(10);
        //eDAO.removerPorChave(e.getClass(), e.getChave());
        
    }
}
