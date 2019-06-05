/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.Entidade;
import java.util.Collection;
import javax.persistence.TypedQuery;
import model.entidades.Entregador;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author rumenik.andrade
 */
public class EntregadorDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select e From Entregador e";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();
	//List<Entidade> resultSet = typedQuery.getResultList();		
	return resultSet;
    } 
    public Entregador consultar(Entregador entregador){
        String querySelect = "Select c From Entregador c where c.telefone = '"+entregador.getTelefone()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Entregador retorno = (Entregador) resultSet.get(0);
	return retorno;
    }
}
