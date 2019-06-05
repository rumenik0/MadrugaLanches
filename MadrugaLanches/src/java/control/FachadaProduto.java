package control;

import java.util.List;
import model.dao.ProdutoDAO;
import model.entidades.Cliente;
import model.entidades.Produto;
import util.ClienteException;
import util.ProdutoException;

/**
 *
 * @author Igor
 */
public class FachadaProduto {
    
    public void verificaPreenchimento(Produto p) throws ProdutoException {
        if (p == null) {
            throw new ProdutoException("Objeto não preenchido!");
        } else if (p.getNome().isEmpty() || p.getNome().equals("")) {
            throw new ProdutoException("Nome vazio!");
        } else if (p.getDescricao().isEmpty() || p.getDescricao().equals("")) {
            throw new ProdutoException("Descrição vazia!");
        } else if (p.getPreco() == null) {
            throw new ProdutoException("Preço vazio!");
        } 
    
    }
    
    public void inserir(Produto produto) {
        ProdutoDAO pd = new ProdutoDAO();     
        pd.inserir(produto);
    }
    public void deletar(Produto produto){
        ProdutoDAO pd = new ProdutoDAO();     
        pd.removerPorObjeto(produto);
    }
    public void atualizar(Produto produto) {
        ProdutoDAO pd = new ProdutoDAO();     
        pd.alterarPorObjeto(produto);
    }    
    public List<Produto> consultarTodosOsProdutos(){
        ProdutoDAO pd = new ProdutoDAO();   
        return (List<Produto>)(List<?>) pd.consultar();
    }    
}
