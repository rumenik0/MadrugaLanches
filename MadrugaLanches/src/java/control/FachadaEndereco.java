/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import interfaces.Entidade;
import java.util.List;
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.entidades.Cliente;
import model.entidades.Endereco;
import util.ClienteException;
import util.EnderecoException;

/**
 *
 * @author Igor
 */
public class FachadaEndereco {
    
    public void verificaPreenchimento(Endereco e) throws EnderecoException {
        if (e == null) {
            throw new EnderecoException("Objeto não preenchido!");
        } else if (e.getBairro().isEmpty() || e.getBairro().equals("")) {
            throw new EnderecoException("Bairro vazio!");
        } else if (e.getCep() == null || e.getBairro().equals("")) {
            throw new EnderecoException("Cep vazio!");
        } else if (e.getLogradouro().isEmpty() || e.getLogradouro().equals("")) {
            throw new EnderecoException("Logradouro vazio!");
        } else if (e.getNumero() == null || e.getNumero().equals("")) {
            throw new EnderecoException("Número vazio!");
        } else if (e.getReferencia().isEmpty() || e.getReferencia().equals("")) {
            throw new EnderecoException("Referência vazio!");
        }
    }
    public void inserir(Endereco endereco) {
        EnderecoDAO ed = new EnderecoDAO();     
        ed.inserir(endereco);
    }
    public void deletar(Endereco endereco){
        EnderecoDAO ed = new EnderecoDAO();     
        ed.removerPorObjeto(endereco);
    }
    public void atualizar(Endereco endereco) {
        EnderecoDAO ed = new EnderecoDAO();     
        ed.alterarPorObjeto(endereco);
    }  
    
    public Endereco consultar(Endereco endereco){
        EnderecoDAO ed = new EnderecoDAO();   
        return (Endereco) ed.consultar(endereco);
    }  
    
    public List<Endereco> consultarTodosOsEnderecos(){
        EnderecoDAO ed = new EnderecoDAO();   
        return (List<Endereco>)(List<?>) ed.consultar();
    }
}
