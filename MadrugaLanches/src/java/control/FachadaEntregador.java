package control;

import java.util.List;
import model.dao.EntregadorDAO;
import model.entidades.Entregador;
import util.EntregadorException;

/**
 *
 * @author Igor
 */
public class FachadaEntregador {
    public void verificaPreenchimento(Entregador e) throws EntregadorException {
        if (e == null) {
            throw new EntregadorException("Objeto não preenchido!");
        } else if (e.getNome().isEmpty() || e.getNome().equals("")) {
            throw new EntregadorException("Nome vazio!");
        } else if (e.getTelefone().isEmpty() || e.getTelefone().equals("")) {
            throw new EntregadorException("Telefone vazio!");
        } else if(!soContemNumeros(e.getTelefone())){
            System.out.println("Entrou aqui");
            throw new EntregadorException("Telefone possui letras!");
        } 
    }
    public static boolean soContemNumeros(String texto) {
        if(texto == null)
            return false;
        for (char letra : texto.toCharArray())
            if(letra < '0' || letra > '9')
                return false;
        return true;         
    }
    
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
    public Entregador consultar(Entregador entregador){
        EntregadorDAO ed = new EntregadorDAO();   
        return (Entregador) ed.consultar(entregador);
    }  
}
