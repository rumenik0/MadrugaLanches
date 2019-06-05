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
import model.entidades.Desconto;

/**
 *
 * @author rumenik.andrade
 */
public class DescontoDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select d From Desconto d";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();
	//List<Entidade> resultSet = typedQuery.getResultList();		
	return resultSet;
    } 
    public Desconto consultar(Desconto desconto){
        String querySelect = "Select c From Desconto c where c.motivo = '"+desconto.getMotivo()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Desconto retorno = (Desconto) resultSet.get(0);
	return retorno;
    }
}
