package control;

import java.util.List;
import model.dao.FilialDAO;
import model.entidades.Filial;

/**
 *
 * @author Igor
 */
public class FachadaFilial {

    public void inserir(Filial filial) {
        FilialDAO fd = new FilialDAO();     
        fd.inserir(filial);
    }
    public void deletar(Filial filial){
        FilialDAO fd = new FilialDAO();     
        fd.removerPorObjeto(filial);
    }
    public void atualizar(Filial filial) {
        FilialDAO fd = new FilialDAO();     
        fd.alterarPorObjeto(filial);
    }    
    public List<Filial> consultarTodosOsFiliais(){
        FilialDAO fd = new FilialDAO();   
        return (List<Filial>)(List<?>) fd.consultar();
    }    
}
