package managedbean;

import control.FachadaEntregador;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Entregador;

@ManagedBean()
@ViewScoped
public class EntregadorMB {
	
	Entregador entregador = new Entregador();
	List<Entregador> listaEntregadores = null;
	
	public EntregadorMB() {}

	public Entregador getEntregador() {
            return entregador;
	}
	
	public void setEntregador(Entregador entregador) {
            this.entregador = entregador; 
	}
	
	public List<Entregador> getListaEntregadores() {
            return listaEntregadores;
	}
	
	public void setListaEntregadores(List<Entregador> listaEntregadores) {
            this.listaEntregadores = listaEntregadores;
	}
	
	
	public void merge() {
            if ( this.entregador != null ) { 
                if(this.entregador.getCodigo() == null){
                    FachadaEntregador fe = new FachadaEntregador();
                    fe.inserir(entregador);			
                    this.listaEntregadores = fe.consultarTodosOsEntregadores();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Entregador " + entregador.getNome() , "adicionado!"));
                }else{
                    FachadaEntregador fe = new FachadaEntregador();
                    fe.atualizar(entregador);
                    this.listaEntregadores = fe.consultarTodosOsEntregadores();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Entregador " + entregador.getNome() , "atualizado!"));
                }
            }
	}
        public void reset(){
            this.entregador = new Entregador();
	}
        public String deletar(Entregador p){
            FachadaEntregador fp = new FachadaEntregador();
            fp.deletar(p);			
	    this.listaEntregadores = fp.consultarTodosOsEntregadores();   
            FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "produto " + p.getNome() , "deletado!"));
            return null;
        }
        public void carregarListaEntregadores (){
            FachadaEntregador fp = new FachadaEntregador();
            this.listaEntregadores = fp.consultarTodosOsEntregadores();  
        }    
}