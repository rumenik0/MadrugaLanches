/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeIntegracao;

import control.FachadaProduto;
import model.entidades.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ProdutoException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoProduto {
    private Produto produto;
    private FachadaProduto fachada;
    
    public JUnitIntegracaoProduto() {
        produto = new Produto();
        fachada = new FachadaProduto();
    }
    
    @After
    public void afterProduto(){
        this.fachada.deletar(this.produto);
    }
    
    @Before
    public void beforeProduto(){
        Produto c  = new Produto();
        c.setNome("Produto teste");
        c.setDescricao("desc produto teste");
        c.setPreco(2.0);
        this.fachada.inserir(c);
        this.produto = this.fachada.consultar(c);
    }
    
    @Test
    public void inserirProdutoTeste() throws ProdutoException{
        Produto c  = new Produto();
        c.setNome("Produto teste Insert");
        c.setDescricao("desc teste");
        c.setPreco(2.0);
        this.fachada.inserir(c);
        
        Produto retorno = this.fachada.consultar(c);
        assertEquals( c.getNome(), retorno.getNome());
        assertEquals( c.getDescricao(), retorno.getDescricao());
        assertEquals( c.getPreco(),retorno.getPreco());
        
        this.fachada.deletar(retorno);

        
    }
    
    @Test(expected=NullPointerException.class)
    public void removerProdutoNull() throws ProdutoException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarProduto() throws ProdutoException{
        this.produto.setNome("teste atualizar");
        this.fachada.atualizar(this.produto);
        assertEquals(this.produto.getNome(),"teste atualizar");
    }
    
    
    @Test
    public void consultarProdutoTeste() throws ProdutoException{
        Produto consulta = this.fachada.consultar(this.produto);
        assertEquals( this.produto.getPreco(), consulta.getPreco());
        assertEquals( this.produto.getDescricao(),consulta.getDescricao());
        assertEquals( this.produto.getNome(),consulta.getNome());
        
    }
    
}
