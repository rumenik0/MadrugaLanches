package TesteFuncional;

import TesteFuncional.TesteFuncionalCliente;
import TesteFuncional.TesteFuncionalProduto;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
    TesteFuncionalCliente.class,
    TesteFuncionalProduto.class
})

public class TesteFuncionalSuite {
    
}
