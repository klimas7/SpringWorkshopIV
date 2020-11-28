package pl.klimas7.spring.core.order;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log
@Component
public class RatingRetriever {
//    @Autowired
//    @Qualifier("good")
    private final Rating rating;

    public RatingRetriever(@Qualifier("good") Rating rating) {
        this.rating = rating;
    }


    @PostConstruct
    public void printRating() {
        log.info("Rating: " + rating.getRating());
    }
}
