package testeSistema;
import testeUnitario.TesteUnitarioSuite;
import testeIntegracao.TesteIntegracaoSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({	
	TesteUnitarioSuite.class,
        TesteIntegracaoSuite.class
})




public class TesteMain {

}
