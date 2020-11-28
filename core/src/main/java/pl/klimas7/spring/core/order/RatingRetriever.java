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

    //DefaultListableBeanFactory.getBeanNamesForType --> this.allBeanNamesByType Tutaj jest zgodnie z alfabetem
    //ClassPathBeanDefinitionScanner -> doScan

    //If add Order
    /*
    DefaultListableBeanFactory.resolveMultipleBeans
    1388
			if (result instanceof List) {
				if (((List<?>) result).size() > 1) {
					Comparator<Object> comparator = adaptDependencyComparator(matchingBeans);
					if (comparator != null) {
						((List<?>) result).sort(comparator);
					}
				}
			}
	OrderComparator
	AnnotationAwareOrderComparator
     */

}
