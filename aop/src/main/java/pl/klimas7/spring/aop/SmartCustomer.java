package pl.klimas7.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SmartCustomer implements Customer{

    @Before("buy()")
    public void chose() {
        log.info("chose()");
    }

    @After("buy()")
    public void checkPrice() {
        log.info("checkPrice()");
    }

    @AfterReturning("buy()")
    public void transport() {
        log.info("transport()");
    }

    @AfterThrowing("buy()")
    public void somethingWrong() {
        log.info("somethingWrong()");
    }
}
