package pl.klimas7.spring.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Log
@Aspect
@Component
@Order(0)
public class XCustomer {

    //@Before("execution(public void pl.klimas7.spring.aop.Shop.buy(..))")
    //@Before("execution(public * pl.klimas7.spring.aop.Shop.buy(..))")
    //(..) zero or more parameters
    @Before("execution(* pl.klimas7.spring.aop.Shop.buy(..))")
    public void chose() {
        log.info("chose()");
    }

    @After("execution(* pl.klimas7.spring.aop.Shop.buy())")
    public void checkPrice() {
        log.info("checkPrice()");
    }

    @AfterReturning("execution(* pl.klimas7.spring.aop.Shop.buy())")
    public void transport() {
        log.info("transport()");
    }

    @AfterThrowing("execution(* pl.klimas7.spring.aop.Shop.buy(..))")
    public void somethingWrong() {
        log.info("somethingWrong()");
    }
}
