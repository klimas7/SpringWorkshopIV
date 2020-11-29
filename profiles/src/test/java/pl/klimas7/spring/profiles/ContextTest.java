package pl.klimas7.spring.profiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("test")
public class ContextTest {

    @Autowired
    private Message message;

    @Test
    public void startContextTest() {
        //Empty
        message.sendMessage();
    }
}
