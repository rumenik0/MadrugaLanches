/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madrugaproject;

import control.FachadaCliente;
import model.entidades.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitCliente {
    
    private Cliente cliente;
    private FachadaCliente fachada;
    public JUnitCliente() {
        cliente = new Cliente();
    }
    
    @Test(expected=NullPointerException.class)
    public void testInserirClienteSemEndereco() {
        cliente = new Cliente(null,"jose","123456789","123");
	fachada.inserir(cliente);
    }
    
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
