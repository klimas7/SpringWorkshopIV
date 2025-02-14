package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Log
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class LazyWorker implements Worker {
    private String uuid;

    public LazyWorker() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doWork() {
        log.info("I'm lazy worker nr: " + uuid);
    }

    @PostConstruct
    private void born() {
        log.info("Born a lazy worker nr: " + uuid);
    }
}
