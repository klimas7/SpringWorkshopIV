package pl.klimas7.spring.core.circular;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CircularDependencyTest {
    @Autowired
    private BeanA beanA;

    @Autowired
    private BeanB beanB;

    @Test
    public void startContextTest() {

    }

    @Test
    public void testPrint() {
        assertEquals(beanB.getMessage(), beanA.getOtherMessage());
        assertEquals(beanA.getMessage(), beanB.getOtherMessage());
    }
}
