package testeUnitario;

import control.FachadaCliente;
import control.FachadaEntregador;
import java.util.Date;
import model.entidades.Cliente;
import model.entidades.Endereco;
import model.entidades.Entregador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ClienteException;
import util.EntregadorException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitEntregador {
    
    private Entregador entregador;
    private FachadaEntregador fachada;
    public JUnitEntregador() {
        entregador = new Entregador();
        fachada = new FachadaEntregador();
    }
    @Test(expected=EntregadorException.class)
    public void testeObjetoVazio() throws EntregadorException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=EntregadorException.class)
    public void testeNomeVazio() throws EntregadorException{
        Entregador e  = new Entregador();
        e.setNome("");
        e.setTelefone("983364139");
        this.fachada.verificaPreenchimento(e);
    }
    @Test(expected=EntregadorException.class)
    public void testeTelefoneVazio() throws EntregadorException{
        Entregador e  = new Entregador();
        e.setNome("");
        e.setTelefone("983364139");
        this.fachada.verificaPreenchimento(e);
    }
}