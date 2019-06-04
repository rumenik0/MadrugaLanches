package control;

import java.util.List;
import model.dao.ProdutoDAO;
import model.entidades.Produto;

/**
 *
 * @author Igor
 */
public class FachadaProduto {

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
