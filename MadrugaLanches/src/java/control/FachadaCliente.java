/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.Entidade;
import java.util.List;
import model.dao.ClienteDAO;
import model.entidades.Cliente;

/**
 *
 * @author Igor
 */
public class FachadaCliente {

    public void inserir(Cliente cliente) {
        ClienteDAO cd = new ClienteDAO();     
        cd.inserir(cliente);
    }
    public void deletar(Cliente cliente){
        ClienteDAO cd = new ClienteDAO();     
        cd.removerPorObjeto(cliente);
    }
    public void atualizar(Cliente cliente) {
        ClienteDAO cd = new ClienteDAO();     
        cd.alterarPorObjeto(cliente);
    }    
    public List<Cliente> consultarTodosOsClientes(){
        ClienteDAO cd = new ClienteDAO();   
        return (List<Cliente>)(List<?>) cd.consultar();
    }   
    
    public Cliente login(Cliente cliente){
        ClienteDAO cd = new ClienteDAO(); 
        Cliente retorno;
        retorno = (Cliente) cd.login(cliente);
        if (retorno.getTelefone().equals(cliente.getTelefone())  && retorno.getSenha().equals(cliente.getSenha()))
            return retorno;
        else
            return null;
        
    }
}
