/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.Entidade;
import model.entidades.Cliente;
import model.entidades.Endereco;

/**
 *
 * @author rumenik.andrade
 */
public class ClienteDAO extends AbstractDAO{
    
    @Override
    public void inserir(Entidade e){
        Cliente c = (Cliente) e;
        EnderecoDAO enDAO = new EnderecoDAO();
        for (Endereco i : c.getEndereco())
            enDAO.inserir(i);
        super.inserir(e);
    }
}
