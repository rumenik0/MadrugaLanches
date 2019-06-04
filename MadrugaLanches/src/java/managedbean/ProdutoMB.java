package managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.entidades.Produto;
import control.FachadaProduto;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean()
@ViewScoped
public class ProdutoMB {
	
	Produto produto = new Produto();
	List<Produto> listaProdutos = null;
	
	public ProdutoMB() {}

	public Produto getProduto() {
            return produto;
	}
	
	public void setProduto(Produto produto) {
            this.produto = produto; 
	}
	
	public List<Produto> getListaProdutos() {
            return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
            this.listaProdutos = listaProdutos;
	}
	
	
	public void merge() {
            if ( this.produto != null ) { 
                if(this.produto.getCodigo() == null){
                    FachadaProduto fp = new FachadaProduto();
                    fp.inserir(produto);			
                    this.listaProdutos = fp.consultarTodosOsProdutos();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto " + produto.getNome() , "adicionado!"));
                }else{
                    FachadaProduto fp = new FachadaProduto();
                    fp.atualizar(produto);
                    this.listaProdutos = fp.consultarTodosOsProdutos();  
                    FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto " + produto.getNome() , "atualizado!"));
                }
            }
	}
        public void reset(){
            this.produto = new Produto();
	}
        public String deletar(Produto p){
            FachadaProduto fp = new FachadaProduto();
            fp.deletar(p);			
	    this.listaProdutos = fp.consultarTodosOsProdutos();   
            FacesContext.getCurrentInstance().addMessage("sucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "produto " + p.getNome() , "deletado!"));
            return null;
        }
        public void carregarListaProdutos (){
            FachadaProduto fp = new FachadaProduto();
            this.listaProdutos = fp.consultarTodosOsProdutos();  
        }    
}