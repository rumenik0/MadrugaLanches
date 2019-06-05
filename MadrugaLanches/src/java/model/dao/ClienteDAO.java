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

/**
 *
 * @author Igor
 */
public class ClienteDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select c From Cliente c";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();
	//List<Entidade> resultSet = typedQuery.getResultList();		
	return resultSet;
    } 
    public Cliente consultar(Cliente cliente){
        String querySelect = "Select c From Cliente c where c.telefone = '"+cliente.getTelefone()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Cliente retorno = (Cliente) resultSet.get(0);
	return retorno;
    }
    public Cliente login(Cliente cliente){
        String querySelect = "Select c From Cliente c where c.telefone = '"+cliente.getTelefone()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        //Collection<Entidade> resultSet = typedQuery.getResultList();
	List<Entidade> resultSet = typedQuery.getResultList();	
        Cliente retorno = (Cliente) resultSet.get(0);
	return retorno;
    } 
}
