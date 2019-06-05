/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.Entidade;
import java.util.Collection;
import java.util.List;
import javax.persistence.TypedQuery;
import model.entidades.Cliente;
import model.entidades.Produto;

/**
 *
 * @author rumen
 */
public class ProdutoDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select p From Produto p";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();	
	return resultSet;
    } 
    
    public Produto consultar(Produto produto){
        String querySelect = "Select c From Produto c where c.nome = '"+ produto.getNome() +"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Produto retorno = (Produto) resultSet.get(0);
	return retorno;
    } 
}
