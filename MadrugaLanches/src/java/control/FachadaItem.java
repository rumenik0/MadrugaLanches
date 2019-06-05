package control;

import java.util.List;
import model.dao.FilialDAO;
import model.entidades.Filial;
import model.entidades.Item;
import util.FilialException;
import util.ItemException;

/**
 *
 * @author Igor
 */
public class FachadaItem {
    public void verificaPreenchimento(Item i) throws ItemException {
        if (i == null) {
            throw new ItemException("Objeto não preenchido!");
        } else if (i.getComentario().isEmpty() || i.getComentario().equals("")) {
            throw new ItemException("Comentário vazio!");
        } else if (i.getProduto() == null) {
            throw new ItemException("Produto vazio!");
        } else if (i.getValorAtual() == null) {
            throw new ItemException("Valor vazio!");
        } 
    }
}
