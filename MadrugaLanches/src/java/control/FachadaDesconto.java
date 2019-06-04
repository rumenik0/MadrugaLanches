package control;

import java.util.List;
import model.dao.DescontoDAO;
import model.entidades.Desconto;

/**
 *
 * @author Igor
 */
public class FachadaDesconto {

    public void inserir(Desconto desconto) {
        DescontoDAO dd = new DescontoDAO();     
        dd.inserir(desconto);
    }
    public void deletar(Desconto desconto){
        DescontoDAO dd = new DescontoDAO();     
        dd.removerPorObjeto(desconto);
    }
    public void atualizar(Desconto desconto) {
        DescontoDAO dd = new DescontoDAO();     
        dd.alterarPorObjeto(desconto);
    }    
    public List<Desconto> consultarTodosOsDescontos(){
        DescontoDAO dd = new DescontoDAO();   
        return (List<Desconto>)(List<?>) dd.consultar();
    }    
}
