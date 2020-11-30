package pl.klimas7.spring.core.diff;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@Log
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class DiffInjectTest {
    @Inject
    private Circle shape;

    @Test
    public void startContextTest() {
        log.info(shape.description());
    }
}
