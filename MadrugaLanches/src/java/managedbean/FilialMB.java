package managedbean;

import control.FachadaFilial;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Endereco;
import model.entidades.Filial;

@ManagedBean()
@ViewScoped
public class FilialMB {
	
	Filial filial = new Filial();        
        Endereco endereco = new Endereco();
        
	List<Filial> listaFiliais = null;
	
	public FilialMB() {}

	public Filial getFilial() {
            return filial;
	}
	
	public void setFilial(Filial filial) {
            this.filial = filial; 
	}
	
	public List<Filial> getListaFiliais() {
            return listaFiliais;
	}
	
	public void setListaFiliais(List<Filial> listaFiliais) {
            this.listaFiliais = listaFiliais;
	}
	public Endereco getEndereco() {
            return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
	}
	
	public void merge() {
            if ( this.filial != null ) { 
                if(this.filial.getCodigo() == null){                    
                    this.filial.setEndereco(endereco);
                    FachadaFilial ff = new FachadaFilial();
                    ff.inserir(filial);			
                    this.listaFiliais = ff.consultarTodosOsFiliais();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Filial " + filial.getNome() , "adicionado!"));
                }else{                    
                    this.filial.setEndereco(endereco);
                    FachadaFilial ff = new FachadaFilial();
                    ff.atualizar(filial);
                    this.listaFiliais = ff.consultarTodosOsFiliais();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Filial " + filial.getNome() , "atualizado!"));
                }
            }
	}
        public void reset(){
            this.filial = new Filial();            
            this.endereco = new Endereco();
	}
        public String deletar(Filial p){
            FachadaFilial fp = new FachadaFilial();
            fp.deletar(p);			
	    this.listaFiliais = fp.consultarTodosOsFiliais();   
            FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "produto " + p.getNome() , "deletado!"));
            return null;
        }
        public void carregarListaFiliais (){
            FachadaFilial fp = new FachadaFilial();
            this.listaFiliais = fp.consultarTodosOsFiliais();  
        }    
}