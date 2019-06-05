/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteFuncional;

import control.FachadaCliente;
import model.entidades.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author rumenik.andrade
 */
public class TesteFuncionalCliente {
    
    static WebDriver browser;
    static ChromeOptions options;
    private Cliente cliente;
    private FachadaCliente fachada;
    
    public TesteFuncionalCliente() {
        cliente = new Cliente();
        fachada = new FachadaCliente();
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","C:/Users/rumenik.andrade/Documents/NetBeansProjects/chromedriver_win32/chromedriver.exe" );
        browser = new ChromeDriver();
        //options = new ChromeOptions();
        //options.addArguments("--whitelist-ip localhost");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        browser.quit();
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void loginTeste(){
        
        browser.get("http://localhost:8080/MadrugaLanches/");
        browser.findElement(By.id("j_idt4:usuario")).sendKeys("979146365");
        browser.findElement(By.id("j_idt4:senha")).sendKeys("123");
        browser.findElement(By.name("j_idt4:btn")).click();
        
        
    }
    
    @Test
    public void cadastroTeste(){
        browser = new ChromeDriver();
        browser.get("http://localhost:8080/MadrugaLanches/faces/cliente.xhtml");
        browser.findElement(By.name("j_idt6:j_idt11")).sendKeys("CLIENTE SELENIUM TESTE");
        browser.findElement(By.name("j_idt6:j_idt13")).sendKeys("81977665544");
        browser.findElement(By.name("j_idt6:j_idt15")).sendKeys("31456456");
        browser.findElement(By.name("j_idt6:j_idt17")).sendKeys("BAIRRO");
        browser.findElement(By.name("j_idt6:j_idt19")).sendKeys("LOGRADOURO");
        browser.findElement(By.name("j_idt6:j_idt21")).sendKeys("666");
        browser.findElement(By.name("j_idt6:j_idt23")).sendKeys("REFERENCIA");
        browser.findElement(By.name("j_idt6:j_idt25")).sendKeys("SENHA");
        browser.findElement(By.name("j_idt6:j_idt26")).click();
        browser.quit();
        
        Cliente c  = new Cliente();
        c.setTelefone("81977665544");
        this.cliente = this.fachada.consultar(c);
        this.fachada.deletar(this.cliente);
        
    }

    
    
    
    
}
