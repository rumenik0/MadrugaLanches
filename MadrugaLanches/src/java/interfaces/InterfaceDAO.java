package interfaces;

import java.util.Collection;
import java.util.List;

public interface InterfaceDAO { 
    public void inserir(Entidade e);
    public void alterarPorObjeto(Entidade e);
    public void removerPorChave(Class classe, Object objeto);
    public void removerPorObjeto(Entidade e);
    public Entidade consultarPorChave(Class classe, Object objeto);
    public Entidade consultarPorObjeto(Entidade e);
}
