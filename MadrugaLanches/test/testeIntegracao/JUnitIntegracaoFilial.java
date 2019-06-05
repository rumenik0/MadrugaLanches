package testeIntegracao;

import control.FachadaFilial;
import junit.framework.Assert;
import model.entidades.Filial;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.FilialException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitIntegracaoFilial {
    
    private Filial filial;
    private FachadaFilial fachada;
    
    public JUnitIntegracaoFilial() {
        filial = new Filial();
        fachada = new FachadaFilial();
    }
    
    @After
    public void afterFilial(){
        //this.fachada.deletar(this.filial);
    }
    
    @Before
    public void beforeFilial(){
        Filial e  = new Filial();
        e.setNome("teste Insert");
        this.fachada.inserir(e);
        this.filial = this.fachada.consultar(e);
    }
    
    @Test
    public void inserirFilialTeste() throws FilialException{
        Filial e  = new Filial();
        e.setNome("teste Insert");
        this.fachada.inserir(e);
        
        Filial retorno = this.fachada.consultar(e);
        assertEquals( e.getNome(), retorno.getNome());
        
        this.fachada.deletar(retorno);
    }
    
    @Test(expected=NullPointerException.class)
    public void removerFilialNull() throws FilialException{
        this.fachada.deletar(null);
    }
    
    @Test
    public void alterarFilial() throws FilialException{
        this.filial.setNome("teste atualizar");
        this.fachada.atualizar(this.filial);
        assertEquals(this.filial.getNome(),"teste atualizar");
    }
    
    
    @Test
    public void consultarFilialTeste() throws FilialException{
        Filial consulta = this.fachada.consultar(this.filial);
        assertEquals( this.filial.getNome(),consulta.getNome());
    }

}
