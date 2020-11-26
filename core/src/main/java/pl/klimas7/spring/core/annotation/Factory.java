package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Log
@Component
public class Factory {
    private Worker bestWorker;
    @Autowired
    @Qualifier(value = "lazyWorker")
    private Worker theMostLazyWorker;

    @Resource
    private Collection<Worker> workers;

    @Autowired
    public void setBestWorker(Worker bestWorker) {
        this.bestWorker = bestWorker;
    }

    public void setTheMostLazyWorker(Worker theMostLazyWorker) {
        this.theMostLazyWorker = theMostLazyWorker;
    }

    public void setWorkers(Collection<Worker> workers) {
        this.workers = workers;
    }

    void doWork() {
        workers.stream()
                .filter(Objects::nonNull)
                .forEach(Worker::doWork);
        log.info("");
        checkAndDoWork(bestWorker, "The Best Worker");
        checkAndDoWork(theMostLazyWorker, "The Most Lazy Worker");
    }

    private void checkAndDoWork(Worker worker, String message) {
        log.info(message);
        Optional.ofNullable(worker)
                .ifPresent(Worker::doWork);
    }
}
