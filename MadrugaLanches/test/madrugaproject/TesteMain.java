package madrugaproject;
import TesteFuncional.TesteFuncionalSuite;
import testeUnitario.TesteUnitarioSuite;
import testeIntegracao.TesteIntegracaoSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({	
	TesteUnitarioSuite.class,
        TesteIntegracaoSuite.class,
        TesteFuncionalSuite.class
})




public class TesteMain {

}
