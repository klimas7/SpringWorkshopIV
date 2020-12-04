package pl.klimas7.spring.mongo;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final MongoOperations mongoOperations;
    private final UserMongoRepository userMongoRepository;

    public UserRepository(MongoOperations mongoOperations, UserMongoRepository userMongoRepository) {
        this.mongoOperations = mongoOperations;
        this.userMongoRepository = userMongoRepository;
    }

    public List<User> save(Iterable<User> users) {
        return userMongoRepository.saveAll(users);
    }

    public List<User> findAll() {
//        return userMongoRepository.findAll();
        return mongoOperations.findAll(User.class);
    }

    public List<User> findByFirstName(String firstName) {
        return userMongoRepository.findUserByFirstName(firstName);
    }

    //db.user.find().sort({userAge: -1}).limit(1)
    public User getOldestUser() {
        /*
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "age"));
        query.limit(1);

        return mongoOperations.findOne(query, User.class);

         */
        return userMongoRepository.findTopByAgeIsAfterOrderByAgeDesc(0);
    }

    //db.user.aggregate([{ "$group" : {_id: "$age", count:{$sum:1}} }])
    public List<AgeCounts> getUserAgeCounts() {
        Aggregation agg = Aggregation.newAggregation(Aggregation.group("age").count().as("count"),
                    Aggregation.project("count").and("age").previousOperation(),
                Aggregation.sort(Sort.Direction.DESC, "age"));

        AggregationResults<AgeCounts> aggregate = mongoOperations.aggregate(agg, User.class, AgeCounts.class);
        return aggregate.getMappedResults();
    }
}
