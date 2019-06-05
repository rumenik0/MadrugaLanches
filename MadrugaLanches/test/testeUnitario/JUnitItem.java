package testeUnitario;

import control.FachadaDesconto;
import control.FachadaItem;
import java.util.Date;
import model.entidades.Desconto;
import model.entidades.Item;
import model.entidades.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DescontoException;
import util.ItemException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitItem {
    
    private Item item;
    private FachadaItem fachada;
    public JUnitItem() {
        item = new Item();
        fachada = new FachadaItem();
    }
    @Test(expected=ItemException.class)
    public void testeObjetoVazio() throws ItemException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=ItemException.class)
    public void testeComentarioVazio() throws ItemException{
        Produto p = new Produto();
        p.setDescricao("Recheio de pitu");
        p.setNome("COXINHA DE pitu");
        p.setPreco(3.00);
        
        Item i  = new Item();
        i.setProduto(p);
        i.setValorAtual(5.0d);
        i.setComentario("");
        this.fachada.verificaPreenchimento(i);        
    }
    @Test(expected=ItemException.class)
    public void testeProdutoVazio() throws ItemException{        
        Item i  = new Item();
        i.setProduto(null);
        i.setValorAtual(5.0d);
        i.setComentario("teste");
        this.fachada.verificaPreenchimento(i);        
    }
    @Test(expected=ItemException.class)
    public void testeValorVazio() throws ItemException{    
        Produto p = new Produto();
        p.setDescricao("Recheio de pitu");
        p.setNome("COXINHA DE pitu");
        p.setPreco(3.00);
        
        Item i  = new Item();
        i.setProduto(p);
        i.setValorAtual(null);
        i.setComentario("teste");
        this.fachada.verificaPreenchimento(i);        
    }
}