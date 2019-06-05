/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeIntegracao;

import control.FachadaEntregador;
import junit.framework.Assert;
import model.entidades.Entregador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.EntregadorException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoEntregador {
    
    private Entregador entregador;
    private FachadaEntregador fachada;
    
    public JUnitIntegracaoEntregador() {
        entregador = new Entregador();
        fachada = new FachadaEntregador();
    }
    
    @After
    public void afterEntregador(){
        this.fachada.deletar(this.entregador);
    }
    
    @Before
    public void beforeEntregador(){
        Entregador e  = new Entregador();
        e.setNome("teste Insert");
        e.setTelefone("81999998888");
        this.fachada.inserir(e);
        this.entregador = this.fachada.consultar(e);
    }
    
    @Test
    public void inserirEntregadorTeste() throws EntregadorException{
        Entregador e  = new Entregador();
        e.setNome("teste Insert");
        e.setTelefone("81999993333");
        this.fachada.inserir(e);
        
        Entregador retorno = this.fachada.consultar(e);
        assertEquals( e.getTelefone(), retorno.getTelefone());
        assertEquals( e.getNome(), retorno.getNome());
        
        this.fachada.deletar(retorno);

        
    }
    
    @Test(expected=NullPointerException.class)
    public void removerEntregadorNull() throws EntregadorException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarEntregador() throws EntregadorException{
        this.entregador.setNome("teste atualizar");
        this.fachada.atualizar(this.entregador);
        assertEquals(this.entregador.getNome(),"teste atualizar");
    }
    
    
    @Test
    public void consultarEntregadorTeste() throws EntregadorException{
        Entregador consulta = this.fachada.consultar(this.entregador);
        assertEquals( this.entregador.getTelefone(), consulta.getTelefone());
        assertEquals( this.entregador.getNome(),consulta.getNome());
        
        
    }

}
