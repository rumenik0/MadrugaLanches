package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.entidades.Cliente;
import control.FachadaCliente;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Endereco;

@ManagedBean()
@ViewScoped
public class ClienteMB implements Serializable{
	
	Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
	FachadaCliente fc = new FachadaCliente();
        
	List<Cliente> listaClientes = null;
	
	public ClienteMB() {
        
        }

	public void login(){
            Cliente login = fc.login(this.cliente);
            if ( login == null)
                FacesContext.getCurrentInstance().addMessage("Falha", new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone ou senha inválido" , "Falha ao logar!"));
            else{
                try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
                }catch(Exception e){
                    FacesContext.getCurrentInstance().addMessage("Erro ao tentar logar", new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), "Login não realizado!"));
                }
            }
        }
	
	public void merge() {
            if ( this.cliente != null ) { 
                if(this.cliente.getCodigo() == null){
                    this.cliente.setEndereco(endereco);
                    fc = new FachadaCliente();
                    fc.inserir(cliente);			
                    this.listaClientes = fc.consultarTodosOsClientes();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente " + cliente.getNome() , "adicionado!"));
                }else{
                    this.cliente.setEndereco(endereco);
                    fc = new FachadaCliente();
                    fc.atualizar(cliente);
                    this.listaClientes = fc.consultarTodosOsClientes();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente " + cliente.getNome() , "atualizado!"));
                }
            }
	}
        public void reset(){
            this.cliente = new Cliente();
            this.endereco = new Endereco();
	}
        public String deletar(Cliente c){
            fc = new FachadaCliente();
            fc.deletar(c);			
	    this.listaClientes = fc.consultarTodosOsClientes();   
            FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente " + c.getNome() , "deletado!"));
            return null;
        }
        public void carregarListaClientes (){
            fc = new FachadaCliente();
            this.listaClientes = fc.consultarTodosOsClientes();  
        }    
        
        public Cliente getCliente() {
            return cliente;
	}
	
	public void setCliente(Cliente cliente) {
            this.cliente = cliente; 
            setEndereco(this.cliente.getEndereco());
	}
	
	public List<Cliente> getListaClientes() {
            return listaClientes;
	}
	
	public void setListaClientes(List<Cliente> listaClientes) {
            this.listaClientes = listaClientes;
	}
        public Endereco getEndereco() {
            return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
	}
}