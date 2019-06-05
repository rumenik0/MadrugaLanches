package testeUnitario;

import control.FachadaCliente;
import control.FachadaProduto;
import java.util.Date;
import model.entidades.Cliente;
import model.entidades.Endereco;
import model.entidades.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ClienteException;
import util.ProdutoException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitProduto {
    
    private Produto produto;
    private FachadaProduto fachada;
    public JUnitProduto() {
        produto = new Produto();
        fachada = new FachadaProduto();
    }
    @Test(expected=ProdutoException.class)
    public void testeObjetoVazio() throws ProdutoException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=ProdutoException.class)
    public void testeNomeVazio() throws ProdutoException{
        Produto p  = new Produto();
        p.setNome("");
        p.setDescricao("teste");
        p.setPreco(0.5d);
        this.fachada.verificaPreenchimento(p);
    }
    @Test(expected=ProdutoException.class)
    public void testeDescricaoVazia() throws ProdutoException{
        Produto p  = new Produto();
        p.setNome("coxinha");
        p.setDescricao("");
        p.setPreco(0.5d);
        this.fachada.verificaPreenchimento(p);
    }
    @Test(expected=ProdutoException.class)
    public void testePrecoVazio() throws ProdutoException{
        Produto p  = new Produto();
        p.setNome("coxinha");
        p.setDescricao("coxinha de mario");
        p.setPreco(null);
        this.fachada.verificaPreenchimento(p);
    }
    @Test
    public void testeSucesso() throws ProdutoException{
        Produto p  = new Produto();
        p.setNome("coxinha");
        p.setDescricao("coxinha de mario");
        p.setPreco(0.5d);
        assertEquals("coxinha",p.getNome());
        assertEquals("coxinha de mario",p.getDescricao());        
        assertEquals("0.5",p.getPreco().toString());
    }
}