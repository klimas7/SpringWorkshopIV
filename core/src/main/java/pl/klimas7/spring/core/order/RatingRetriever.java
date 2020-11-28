package pl.klimas7.spring.core.order;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Log
@Component
public class RatingRetriever {
//    @Autowired
//    @Qualifier("good")
    private final Rating rating;

    private final List<Rating> ratings;

    public RatingRetriever(@Qualifier("good") Rating rating,
                           List<Rating> ratings) {
        this.rating = rating;
        this.ratings = ratings;
    }


    @PostConstruct
    public void printRating() {
        log.info("Rating: " + rating.getRating());
        ratings.forEach(r -> log.info("Rating: " + r.getRating() + " (" + r.getClass().getSimpleName() + ")"));
    }
}
