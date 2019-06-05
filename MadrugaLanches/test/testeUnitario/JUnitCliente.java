/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUnitario;

import control.FachadaCliente;
import java.util.Date;
import model.entidades.Cliente;
import model.entidades.Endereco;
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
public class JUnitCliente {
    
    private Cliente cliente;
    private FachadaCliente fachada;
    public JUnitCliente() {
        cliente = new Cliente();
        fachada = new FachadaCliente();
    }
    
    //@Test(expected=NullPointerException.class)
    //public void testInserirClienteSemEndereco() {
        //cliente = new Cliente();
	//fachada.inserir(cliente);
    //}
    @Test(expected=ClienteException.class)
    public void testeObjetoVazio() throws ClienteException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=ClienteException.class)
    public void testeNomeVazio() throws ClienteException{
        Cliente c  = new Cliente();
        c.setCodigo(1);
        c.setNome("");
        c.setSenha("123");
        c.setTelefone("81983336444");
        this.fachada.verificaPreenchimento(c);
    }
    @Test(expected=ClienteException.class)
    public void testeSenhaVazia() throws ClienteException{
        Cliente c  = new Cliente();
        c.setCodigo(1);
        c.setNome("Igor");
        c.setSenha("");
        c.setTelefone("81983336444");
        this.fachada.verificaPreenchimento(c);
    }
    @Test(expected=ClienteException.class)
    public void testeTelefoneVazio() throws ClienteException{
        Cliente c  = new Cliente();
        c.setCodigo(1);
        c.setNome("Igor");
        c.setSenha("123");
        c.setTelefone("");
        this.fachada.verificaPreenchimento(c);
    }
    @Test(expected=ClienteException.class)
    public void testeDataVazia() throws ClienteException{
        Cliente c  = new Cliente();
        c.setCodigo(1);
        c.setDataInicio(null);
        c.setNome("Igor");
        c.setSenha("123");
        c.setTelefone("1234");
        this.fachada.verificaPreenchimento(c);
    }
    /*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}