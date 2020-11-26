package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log
@Component
public class LazyWorker implements Worker {
    private String uuid;

    public LazyWorker() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doWork() {
        log.info("I'm lazy worker nr: " + uuid);
    }
}
