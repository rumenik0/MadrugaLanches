package testeIntegracao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	JUnitIntegracaoCliente.class,
        JUnitIntegracaoDesconto.class,
        JUnitIntegracaoEndereco.class,
        JUnitIntegracaoEntregador.class,
        JUnitIntegracaoFilial.class,
        JUnitIntegracaoProduto.class
})


public class TesteIntegracaoSuite {

}
