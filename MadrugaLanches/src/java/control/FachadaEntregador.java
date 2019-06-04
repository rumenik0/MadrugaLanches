package control;

import java.util.List;
import model.dao.EntregadorDAO;
import model.entidades.Entregador;

/**
 *
 * @author Igor
 */
public class FachadaEntregador {

    public void inserir(Entregador entregador) {
        EntregadorDAO ed = new EntregadorDAO();     
        ed.inserir(entregador);
    }
    public void deletar(Entregador entregador){
        EntregadorDAO ed = new EntregadorDAO();     
        ed.removerPorObjeto(entregador);
    }
    public void atualizar(Entregador entregador) {
        EntregadorDAO ed = new EntregadorDAO();     
        ed.alterarPorObjeto(entregador);
    }    
    public List<Entregador> consultarTodosOsEntregadores(){
        EntregadorDAO ed = new EntregadorDAO();   
        return (List<Entregador>)(List<?>) ed.consultar();
    }    
}
