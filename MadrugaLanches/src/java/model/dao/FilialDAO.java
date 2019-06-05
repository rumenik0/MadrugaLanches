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
import model.entidades.Filial;

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
     public Filial consultar(Filial filial){
        String querySelect = "Select c From Filial c where c.nome = '"+filial.getNome()+"'";		
	TypedQuery<Entidade> typedQuery = 
	InstanciaJPA.getEntityManager().createQuery(
	querySelect, 
	Entidade.class);	
        
	List<Entidade> resultSet = typedQuery.getResultList();	
        Filial retorno = (Filial) resultSet.get(0);
	return retorno;
    }
}
