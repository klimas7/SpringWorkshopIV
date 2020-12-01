package pl.klimas7.spring.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Slf4j
@Component
public class CommonContextListener {

    @EventListener
    public void refreshContextEvent(ContextRefreshedEvent cre) {
        log.info("Refresh event: " + cre.getSource());
    }

    @EventListener
    public void startedContextEvent(ContextStartedEvent cse) {
        log.info("Started event: " + cse.getSource());
    }

    @EventListener
    public void stoppedContextEvent(ContextStoppedEvent cse) {
        log.info("Stopped event: " + cse.getSource());
    }

    @EventListener(classes = {ContextClosedEvent.class, ApplicationReadyEvent.class,
                              ServletRequestHandledEvent.class})
    public void otherContextEvents(ApplicationEvent event) {
        log.info("Other event: " + event.getSource());
    }
}
