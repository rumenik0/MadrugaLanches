/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteFuncional;

import static TesteFuncional.TesteFuncionalCliente.browser;
import static TesteFuncional.TesteFuncionalCliente.options;
import control.FachadaProduto;
import model.entidades.Produto;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
public class TesteFuncionalProduto {
    static WebDriver browser;
    static ChromeOptions options;
    private Produto produto;
    private FachadaProduto fachada;
    
    public TesteFuncionalProduto() {
        produto = new Produto();
        fachada = new FachadaProduto();
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","C:/Users/rumenik.andrade/Documents/NetBeansProjects/chromedriver_win32/chromedriver.exe" );
        options = new ChromeOptions();
        options.addArguments("--whitelist-ip localhost");
        browser = new ChromeDriver();
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
    public void cadastroProduto(){
        
        browser.get("http://localhost:8080/MadrugaLanches/faces/produto.xhtml");
        browser.findElement(By.name("j_idt6:j_idt11")).sendKeys("PRODUTO SELENIUM TESTE");
        browser.findElement(By.name("j_idt6:j_idt13")).sendKeys("DESCRICAO PRODUTO SELENIUM TESTE");
        browser.findElement(By.name("j_idt6:j_idt15")).sendKeys("3.00");
        browser.findElement(By.name("j_idt6:j_idt17")).click();
        
        
        Produto c  = new Produto();
        c.setNome("PRODUTO SELENIUM TESTE");
        this.produto = this.fachada.consultar(c);
        //assertEquals(this.produto.getNome(),c.getNome());
        //assertEquals(this.produto.getDescricao(),c.getDescricao());
        //assertEquals(this.produto.getPreco(),c.getPreco());
        this.fachada.deletar(this.produto);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
