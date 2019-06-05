package testeUnitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	JUnitCliente.class,
        JUnitDesconto.class,
        JUnitEndereco.class,
	JUnitEntregador.class,
        JUnitFilial.class,
        JUnitItem.class,
	JUnitProduto.class
})


public class TesteUnitarioSuite {

}
