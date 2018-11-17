/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author rumen
 */
public abstract class AbstractDAO implements InterfaceDAO {
    
    @Override
    public  void inserir(Entidade e) {
        inserir(e, InstanciaJPA.getEntityManager(), true);
    }
    public void inserir(Entidade e, EntityManager pEM, boolean pFecharEM) {
		pEM.getTransaction().begin();
		pEM.persist(e);
		pEM.getTransaction().commit();
		if( pFecharEM )
			pEM.close();
    }
    
    
    @Override
    public void alterar(Entidade e) {
        alterarPorObjeto(e,InstanciaJPA.getEntityManager(), true);
    }
    public void alterarPorObjeto(Entidade e, EntityManager pEM, boolean pFecharEM){
	pEM.getTransaction().begin();
	pEM.persist(e);
	pEM.getTransaction().commit();
	if( pFecharEM )
            pEM.close();
    }
    
    
    @Override
    public void removerPorChave(Class classe, Object objeto) {
        removerPorChave(classe, objeto,InstanciaJPA.getEntityManager(), true);
    }
    public void removerPorChave(Class pClasse,Object pChavePrimaria,EntityManager pEntityManager,boolean pFecharEntityManager){
	pEntityManager.getTransaction().begin();
	Object registro = pEntityManager.find(pClasse, pChavePrimaria);
	pEntityManager.remove(registro);
	pEntityManager.getTransaction().commit();
	if ( pFecharEntityManager )
            pEntityManager.close();
    }
    
    
    @Override
    public void removerPorObjeto(Entidade e) {
        removerPorObjeto(e, InstanciaJPA.getEntityManager(), true);
    }
    public void removerPorObjeto(Entidade e,EntityManager pEntityManager,boolean pFecharEntityManager) {
	EntityTransaction transacao = pEntityManager.getTransaction();
	transacao.begin();
	Object registro = pEntityManager.find(
	e.getClass(),
	e.getChave());
	pEntityManager.remove(registro);
	transacao.commit();
	if ( pFecharEntityManager )
            pEntityManager.close();
    }
    
    @Override
    public Entidade consultarPorChave(Class classe, Object objeto) {
        return consultarPorChave(classe, objeto, InstanciaJPA.getEntityManager(), true);
    }
    public Entidade consultarPorChave(Class pClasse,Object pPrimaryKey,EntityManager pEntityManager,boolean pFecharEntityManager) {
	Entidade registro = (Entidade) pEntityManager.find(pClasse, pPrimaryKey);
	if ( pFecharEntityManager ) 
            pEntityManager.close();
	return registro;
    }
    
    @Override
    public Entidade consultarPorObjeto(Entidade e) {
        return consultarPorObjeto(e, InstanciaJPA.getEntityManager(), true);
    }
    public Entidade consultarPorObjeto(Entidade e,EntityManager pEntityManager,boolean pFecharEntityManager){
	Entidade registro =	(Entidade) pEntityManager.find(	e.getClass(),e.getChave());
	if ( pFecharEntityManager )
		pEntityManager.close();
	return registro;
    }
}
