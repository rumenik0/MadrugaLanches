package control;

import java.util.List;
import model.dao.DescontoDAO;
import model.entidades.Desconto;
import util.DescontoException;

/**
 *
 * @author Igor
 */
public class FachadaDesconto {
    
    public void verificaPreenchimento(Desconto d) throws DescontoException {
        if (d == null) {
            throw new DescontoException("Objeto não preenchido!");
        } else if (d.getMotivo().isEmpty() || d.getMotivo().equals("")) {
            throw new DescontoException("Motivo vazio!");
        } else if (d.getValor() == null) {
            throw new DescontoException("Valor vazio!");
        } 
    }
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
    public Desconto consultar(Desconto desconto){
        DescontoDAO cd = new DescontoDAO();   
        return (Desconto) cd.consultar(desconto);
    } 
}
