package pl.klimas7.spring.core.diff;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@Log
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource("classpath:test.properties")
public class ResourceAsPropertiesTest {

    @Resource(name = "${my.bean.name}")
    private Shape shape;

    @Test
    public void startContextTest() {
        log.info(shape.description());
    }
}
