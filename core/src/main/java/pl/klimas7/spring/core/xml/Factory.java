package pl.klimas7.spring.core.xml;

import lombok.extern.java.Log;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Log
public class Factory {
    private Worker bestWorker;
    private Worker theMostLazyWorker;
    private Collection<Worker> workers;

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

        checkAndDoWork(bestWorker, "The Best Worker");
        checkAndDoWork(theMostLazyWorker, "The Most Lazy Worker");
    }

    private void checkAndDoWork(Worker worker, String message) {
        log.info(message);
        Optional<Worker> testWorker = Optional.ofNullable(worker);
        testWorker.ifPresent(Worker::doWork);
    }
}

/* Scope:
- singleton
- prototype
Web:
- request
- session
- application
- websocket


 */
