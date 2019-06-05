/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeIntegracao;

import control.FachadaDesconto;
import junit.framework.Assert;
import model.entidades.Desconto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DescontoException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoDesconto {
    
    private Desconto desconto;
    private FachadaDesconto fachada;
    
    public JUnitIntegracaoDesconto() {
        desconto = new Desconto();
        fachada = new FachadaDesconto();
    }
    
    @After
    public void afterDesconto(){
        //this.fachada.deletar(this.desconto);
    }
    
    @Before
    public void beforeDesconto(){
        Desconto d  = new Desconto();
        d.setMotivo("testeMotivo");
        d.setValor(1.0);
        this.fachada.inserir(d);
        this.desconto = this.fachada.consultar(d);
    }
    
    @Test
    public void inserirDescontoTeste() throws DescontoException{
        Desconto d  = new Desconto();
         d.setMotivo("testeMotivo");
        d.setValor(1.0);
        this.fachada.inserir(d);
        
        Desconto retorno = this.fachada.consultar(d);
        assertEquals( d.getMotivo(), retorno.getMotivo());
        assertEquals( d.getValor(), retorno.getValor());
        
        this.fachada.deletar(retorno);

        
    }
    
    @Test(expected=NullPointerException.class)
    public void removerDescontoNull() throws DescontoException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarDesconto() throws DescontoException{
        this.desconto.setMotivo("testeAtualizar");
        this.fachada.atualizar(this.desconto);
        assertEquals(this.desconto.getMotivo(),"testeAtualizar");
    }
    
    
    @Test
    public void consultarDescontoTeste() throws DescontoException{
        Desconto consulta = this.fachada.consultar(this.desconto);
        assertEquals( this.desconto.getMotivo(), consulta.getMotivo());
        assertEquals( this.desconto.getValor(),consulta.getValor());
    }

}
