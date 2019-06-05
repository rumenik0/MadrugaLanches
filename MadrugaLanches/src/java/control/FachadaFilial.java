package control;

import java.util.List;
import model.dao.FilialDAO;
import model.entidades.Filial;
import util.FilialException;

/**
 *
 * @author Igor
 */
public class FachadaFilial {
    public void verificaPreenchimento(Filial f) throws FilialException {
        if (f == null) {
            throw new FilialException("Objeto não preenchido!");
        } else if (f.getNome().isEmpty() || f.getNome().equals("")) {
            throw new FilialException("Nome vazio!");
        } else if (f.getEndereco() == null) {
            throw new FilialException("Endereço vazio!");
        } 
    }
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
