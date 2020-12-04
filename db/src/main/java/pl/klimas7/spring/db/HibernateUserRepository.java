package pl.klimas7.spring.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.klimas7.spring.db.model.User;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository("hibernate")
public class HibernateUserRepository implements UserRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Long count() {
        return (long) findAll().size();
    }

    @Override
    public List<User> findRecent() {
        return findRecent(3);
    }

    @Override
    public List<User> findRecent(int count) {
        var session = getCurrentSession();
        var cb = session.getCriteriaBuilder();
        var query = cb.createQuery(User.class);

        var root = query.from(User.class);
        query.orderBy(cb.desc(root.get("age")));
        return session.createQuery(query)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public User findOne(long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public User save(User user) {
        Serializable id = getCurrentSession().save(user);
        return new User((Long) id, user.getFirstName(), user.getLastName(), user.getAge(), user.getBirthDate());
    }

    @Override
    @Transactional
    public void delete(long id) {
        getCurrentSession().delete(findOne(id));
    }

    private List<User> findAll() {
        Session session = getCurrentSession();
        CriteriaQuery<User> query = session.getCriteriaBuilder().createQuery(User.class);
        query.from(User.class);
        return session.createQuery(query).getResultList();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
