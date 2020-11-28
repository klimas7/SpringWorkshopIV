package pl.klimas7.spring.core.other;

import lombok.extern.java.Log;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Log
@Component
public class SmartBean implements InitializingBean, DisposableBean  {
    private final List<User> users;
    private User otherUser;

    //Uwaga dodać drugi konstruktor i pokazać że jak sa dwa to jeden musi mieć Autowired

    /*
    //@Autowired
    private SmartBean(User user) {
        this.users = Collections.singletonList(user);
        log.info("Users: " + users);
    }

    //@Autowired
    private SmartBean(User user, User user2) {
        this.users = Arrays.asList(user, user2);
        log.info("Users: " + users);
    }
    */

    //@Autowired
    public SmartBean(List<User> users) {
        this.users = users;//Arrays.asList(user, user2);
        log.info("Users: " + users);
    }


    //@Resource
    @Autowired
    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
        log.info("Other user: " + otherUser);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Post Construct");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Shutting down SmartBean");
        System.out.println("SOUT: Shutting down SmartBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Initializing SmartBean");
    }
}
