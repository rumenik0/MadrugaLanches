/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.Entidade;
import java.util.Collection;
import javax.persistence.TypedQuery;

/**
 *
 * @author rumenik.andrade
 */
public class FilialDAO extends AbstractDAO{
    public Collection<Entidade> consultar(){
        String querySelect = "Select f From Filial f";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
        Collection<Entidade> resultSet = typedQuery.getResultList();
	//List<Entidade> resultSet = typedQuery.getResultList();		
	return resultSet;
    } 
}
