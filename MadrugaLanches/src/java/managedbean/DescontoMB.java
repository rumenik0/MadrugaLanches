package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.entidades.Desconto;
import control.FachadaDesconto;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean()
@ViewScoped
public class DescontoMB {
	
	Desconto desconto = new Desconto();
	List<Desconto> listaDescontos = null;
	
	public DescontoMB() {}

	public Desconto getDesconto() {
            return desconto;
	}
	
	public void setDesconto(Desconto desconto) {
            this.desconto = desconto; 
	}
	
	public List<Desconto> getListaDescontos() {
            return listaDescontos;
	}
	
	public void setListaDescontos(List<Desconto> listaDescontos) {
            this.listaDescontos = listaDescontos;
	}
	
	
	public void merge() {
            if ( this.desconto != null ) { 
                if(this.desconto.getCodigo() == null){
                    FachadaDesconto fd = new FachadaDesconto();
                    fd.inserir(desconto);			
                    this.listaDescontos = fd.consultarTodosOsDescontos();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Desconto " , "adicionado!"));
                }else{
                    FachadaDesconto fd = new FachadaDesconto();
                    fd.atualizar(desconto);
                    this.listaDescontos = fd.consultarTodosOsDescontos();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Desconto " , "atualizado!"));
                }
            }
	}
        public void reset(){
            this.desconto = new Desconto();
	}
        public String deletar(Desconto p){
            FachadaDesconto fd = new FachadaDesconto();
            fd.deletar(p);			
	    this.listaDescontos = fd.consultarTodosOsDescontos();   
            FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Desconto ", "deletado!"));
            return null;
        }
        public void carregarListaDescontos (){
            FachadaDesconto fd = new FachadaDesconto();
            this.listaDescontos = fd.consultarTodosOsDescontos();  
        }    
}