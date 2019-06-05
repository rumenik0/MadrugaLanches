/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeIntegracao;

import control.FachadaCliente;
import junit.framework.Assert;
import model.entidades.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ClienteException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoCliente {
    
    private Cliente cliente;
    private FachadaCliente fachada;
    
    public JUnitIntegracaoCliente() {
        cliente = new Cliente();
        fachada = new FachadaCliente();
    }
    
    @After
    public void afterCliente(){
        this.fachada.deletar(this.cliente);
    }
    
    @Before
    public void beforeCliente(){
        Cliente c  = new Cliente();
        c.setNome("teste Insert");
        c.setSenha("123");
        c.setTelefone("81999998888");
        this.fachada.inserir(c);
        this.cliente = this.fachada.consultar(c);
    }
    
    @Test
    public void inserirClienteTeste() throws ClienteException{
        Cliente c  = new Cliente();
        c.setNome("teste Insert");
        c.setSenha("123");
        c.setTelefone("81999993333");
        this.fachada.inserir(c);
        
        Cliente retorno = this.fachada.consultar(c);
        assertEquals( c.getTelefone(), retorno.getTelefone());
        assertEquals( c.getNome(), retorno.getNome());
        assertEquals( c.getSenha(),retorno.getSenha());
        
        this.fachada.deletar(retorno);

        
    }
    
    @Test(expected=NullPointerException.class)
    public void removerClienteNull() throws ClienteException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarCliente() throws ClienteException{
        this.cliente.setNome("teste atualizar");
        this.fachada.atualizar(this.cliente);
        assertEquals(this.cliente.getNome(),"teste atualizar");
    }
    
    
    @Test
    public void consultarClienteTeste() throws ClienteException{
        Cliente consulta = this.fachada.consultar(this.cliente);
        assertEquals( this.cliente.getTelefone(), consulta.getTelefone());
        assertEquals( this.cliente.getNome(),consulta.getNome());
        assertEquals( this.cliente.getSenha(),consulta.getSenha());
        assertEquals( this.cliente.getEndereco(), consulta.getEndereco());
        
        
    }

}
