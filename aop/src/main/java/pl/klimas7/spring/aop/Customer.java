package pl.klimas7.spring.aop;


import org.aspectj.lang.annotation.Pointcut;

public interface Customer {
    @Pointcut("execution(* pl.klimas7.spring.aop.Shop.buy(..))")
    default void buy() {
    }

    @Pointcut("execution(* pl.klimas7.spring.aop.Shop.addToBasket(String)) && args(name)")
    default void addToBasket(String name) {
    }
}
