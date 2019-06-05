package testeUnitario;

import control.FachadaCliente;
import control.FachadaEndereco;
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
import util.EnderecoException;

/**
 *
 * @author rumenik.andrade
 */
public class JUnitEndereco {
    
    private Endereco endereco;
    private FachadaEndereco fachada;
    public JUnitEndereco() {
        endereco = new Endereco();
        fachada = new FachadaEndereco();
    }
    @Test(expected=EnderecoException.class)
    public void testeObjetoVazio() throws EnderecoException{
        this.fachada.verificaPreenchimento(null);
    }
    @Test(expected=EnderecoException.class)
    public void testeBairroVazio() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("");
        e.setCep(51280170);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(50);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.verificaPreenchimento(e);
    }
    @Test(expected=EnderecoException.class)
    public void testeCepVazio() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(null);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(50);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.verificaPreenchimento(e);
    }
    @Test(expected=EnderecoException.class)
    public void testeLogradouroVazio() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(51280170);
        e.setLogradouro("");
        e.setNumero(50);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.verificaPreenchimento(e);
    }
    @Test(expected=EnderecoException.class)
    public void testeNumeroVazio() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(51280170);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(null);
        e.setReferencia("Praça dalva de oliveira");
        this.fachada.verificaPreenchimento(e);
    }
    @Test(expected=EnderecoException.class)
    public void testeReferenciaVazio() throws EnderecoException{
        Endereco e  = new Endereco();
        e.setBairro("Ibura");
        e.setCep(51280170);
        e.setLogradouro("Rua Tocantinópolis");
        e.setNumero(50);
        e.setReferencia("");
        this.fachada.verificaPreenchimento(e);
    }
}