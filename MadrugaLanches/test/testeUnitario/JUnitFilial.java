package testeUnitario;

import control.FachadaDesconto;
import control.FachadaFilial;
import java.util.Date;
import model.entidades.Desconto;
import model.entidades.Endereco;
import model.entidades.Filial;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DescontoException;
import util.FilialException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitFilial {
    
    private Filial filial;
    private FachadaFilial fachada;
    public JUnitFilial() {
        filial = new Filial();
        fachada = new FachadaFilial();
    }
    @Test(expected=FilialException.class)
    public void testeObjetoVazio() throws FilialException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=FilialException.class)
    public void testeNomeVazio() throws FilialException{
        Filial f  = new Filial();
        f.setNome("");
        Endereco e = new Endereco(51330270,"IBURA","CASA", 35, "Esquina com a Rua 24");
        f.setEndereco(e);
        this.fachada.verificaPreenchimento(f);
    }
    @Test(expected=FilialException.class)
    public void testeEnderecoVazio() throws FilialException{
        Filial f  = new Filial();
        f.setNome("Ur2");
        f.setEndereco(null);
        this.fachada.verificaPreenchimento(f);
    }
    @Test
    public void testeSucesso() throws FilialException{
        Endereco e = new Endereco(51330270,"IBURA","CASA", 35, "Esquina com a Rua 24");
        Filial f  = new Filial();
        f.setNome("Ur2");
        f.setEndereco(e);        
        assertEquals("Ur2",f.getNome());
        assertEquals(e,f.getEndereco());        
    }
}