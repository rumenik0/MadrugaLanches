package testeUnitario;

import control.FachadaDesconto;
import java.util.Date;
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
public class JUnitDesconto {
    
    private Desconto desconto;
    private FachadaDesconto fachada;
    public JUnitDesconto() {
        desconto = new Desconto();
        fachada = new FachadaDesconto();
    }
    @Test(expected=DescontoException.class)
    public void testeObjetoVazio() throws DescontoException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=DescontoException.class)
    public void testeNomeVazio() throws DescontoException{
        Desconto d  = new Desconto();
        d.setMotivo("");
        this.fachada.verificaPreenchimento(d);
    }
    @Test(expected=DescontoException.class)
    public void testePrecoVazio() throws DescontoException{
        Desconto d  = new Desconto();
        d.setMotivo("Dia do trabalhador");
        d.setValor(null);
        this.fachada.verificaPreenchimento(d);
    }
    @Test
    public void testeSucesso() throws DescontoException{
        Desconto d  = new Desconto();
        d.setMotivo("Dia do trabalhador");
        d.setValor(1.5d);
        assertEquals("Dia do trabalhador",d.getMotivo());
        assertEquals("1.5",d.getValor().toString());
    }
}