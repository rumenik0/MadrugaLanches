/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeIntegracao;

import control.FachadaEndereco;
import junit.framework.Assert;
import model.entidades.Endereco;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.EnderecoException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoEndereco {
    
    private Endereco endereco;
    private FachadaEndereco fachada;
    
    public JUnitIntegracaoEndereco() {
        endereco = new Endereco();
        fachada = new FachadaEndereco();
    }
    
    @After
    public void afterEndereco(){
        this.fachada.deletar(this.endereco);
    }
    
    @Before
    public void beforeEndereco(){
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(51280172);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(50);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.inserir(e);
        this.endereco = this.fachada.consultar(e);
    }
    
    @Test
    public void inserirEnderecoTeste() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(51280173);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(50);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.inserir(e);
        
        Endereco retorno = this.fachada.consultar(e);
        assertEquals(e.getBairro(), retorno.getBairro());
        assertEquals(e.getCep(), retorno.getCep());
        assertEquals(e.getLogradouro(),retorno.getLogradouro());
        assertEquals(e.getNumero(),retorno.getNumero());        
        assertEquals(e.getReferencia(),retorno.getReferencia());
        
        this.fachada.deletar(retorno);

        
    }
    
    @Test(expected=NullPointerException.class)
    public void removerEnderecoNull() throws EnderecoException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarEndereco() throws EnderecoException{
        this.endereco.setBairro("teste atualizar");
        this.fachada.atualizar(this.endereco);
        assertEquals(this.endereco.getBairro(),"teste atualizar");
    }
    
    
    @Test
    public void consultarEnderecoTeste() throws EnderecoException{
        Endereco consulta = this.fachada.consultar(this.endereco);
        assertEquals(this.endereco.getBairro(), consulta.getBairro());
        assertEquals(this.endereco.getCep(),consulta.getCep());
        assertEquals(this.endereco.getLogradouro(),consulta.getLogradouro());
        assertEquals(this.endereco.getNumero(), consulta.getNumero());
        assertEquals(this.endereco.getReferencia(), consulta.getReferencia());                
    }

}
