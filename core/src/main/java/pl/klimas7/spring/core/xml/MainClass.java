package pl.klimas7.spring.core.xml;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class MainClass {

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //! FileSystemXmlApplicationContext
        log.info("After creating context");

        //DefaultListableBeanFactory

        log.info("Before getBean");
        //getBean -> DefaultListableBeanFactory -> DefaultSingletonBeanRegistry
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.print();

        helloWorld.setMessage("test");
        helloWorld.print();

        log.info("//-----------------");
        var helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        helloWorld2.print();


        log.info("//-----------------");
        var helloWorldBySetter = (HelloWorld) context.getBean("helloWorldSetter");
        helloWorldBySetter.print();

        var helloWorldByConstructor = context.getBean("helloWordConstructor", HelloWorld.class);
        helloWorldByConstructor.print();


        log.info("//-----------------");
        var factory = context.getBean("factory", Factory.class);
        factory.doWork();


        context.close();
    }
}

/*
* 1. Inne sposoby na utworzenie kontekstu
    - ClassPathXmlApplicationContext
    - FileSystemXmlApplicationContext

    - AnnotationConfigApplicationContext

* 2. Gdzie jest przetwarzany wskazany *.xml
    - AbstractApplicationContext.refresh
        AbstractRefreshableApplicationContext.refreshBeanFactory
            AbstractXmlApplicationContext.loadBeanDefinitions

            DefaultListableBeanFactory.registerBeanDefinition
            // this.beanDefinitionNames.add(beanName); linia 986 rejestruje nazwy dostępnych beanów w configuracji


     DefaultListableBeanFactory.refresh
    // Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

	//Finalnie
	BeanUtils.instantiateClass
	    return ctor.newInstance(argsWithDefaultValues)
	    //newInstance !!! -> java.lang.reflect.Constructor
	    *
	A co potem
	* DefaultSingletonBeanRegistry
		protected void addSingleton(String beanName, Object singletonObject) {
		synchronized (this.singletonObjects) {
			this.singletonObjects.put(beanName, singletonObject);
			this.singletonFactories.remove(beanName);
			this.earlySingletonObjects.remove(beanName);
			this.registeredSingletons.add(beanName);
		}
	}

	* AbstractBeanFactory
	    DefaultSingletonBeanRegistry.getSingleton
	        // Quick check for existing instance without full singleton lock
		    Object singletonObject = this.singletonObjects.get(beanName);

*
 */