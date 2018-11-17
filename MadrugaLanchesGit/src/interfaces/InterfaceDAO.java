/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
/**
 *
 * @author rumenik
 */
public interface InterfaceDAO { 
    public void inserir(Entidade e);
    public void alterarPorObjeto(Entidade e);
    public void removerPorChave(Class classe, Object objeto);
    public void removerPorObjeto(Entidade e);
    public Entidade consultarPorChave(Class classe, Object objeto);
    public Entidade consultarPorObjeto(Entidade e);
}
