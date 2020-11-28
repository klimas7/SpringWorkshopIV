package pl.klimas7.spring.core.other;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserFactory implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User(UUID.randomUUID().toString(), "John Rambo", "john.rambo@acme.com");
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
