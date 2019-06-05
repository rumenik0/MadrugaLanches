/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entidades.Endereco;
import interfaces.Entidade;
import java.util.Collection;
import java.util.List;
import javax.persistence.TypedQuery;
import model.entidades.Cliente;

/**
 *
 * @author rumenik.andrade
 */
public class EnderecoDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select c From Endereco c";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();
	//List<Entidade> resultSet = typedQuery.getResultList();		
	return resultSet;
    }
    public Endereco consultar(Endereco endereco){
        String querySelect = "Select c From Endereco c where c.cep = '"+endereco.getCep()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Endereco retorno = (Endereco) resultSet.get(0);
	return retorno;
    }
}
