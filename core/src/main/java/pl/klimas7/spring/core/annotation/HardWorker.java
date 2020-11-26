package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;
@Log
@Component
@Scope(value = "singleton")
@Lazy
public class HardWorker implements Worker {
    private String uuid;

    public HardWorker() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doWork() {
        log.info("I'm hard worker nr: " + uuid);
    }

    @PostConstruct
    private void born() {
        log.info("Born a hard worker nr: " + uuid);
    }
}
