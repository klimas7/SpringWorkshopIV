package pl.klimas7.spring.jmx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmxConfiguration {

    /*
    Or In VM options:
    -Dcom.sun.management.jmxremote=true
    -Dcom.sun.management.jmxremote.port=9001
    -Dcom.sun.management.jmxremote.host=localhost
    -Dcom.sun.management.jmxremote.ssl=false
    -Dcom.sun.management.jmxremote.authenticate=false
    -Djava.rmi.server.hostname=127.0.0.1

    hostname -i
     */

//    @Bean
//    public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
//        RmiRegistryFactoryBean rrfb = new RmiRegistryFactoryBean();
//        rrfb.setPort(9001);
//        return rrfb;
//    }
//
//    @Bean
//    public ConnectorServerFactoryBean connectorServerFactoryBean() throws MalformedObjectNameException {
//        ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
//        csfb.setObjectName("connector:name=rmi");
//        csfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:9001/jmxApplication");
//        return csfb;
//    }

    @Bean
    public MBeanExporter mBeanExporter(MessageManageOperation messageManageOperation) {
        MBeanExporter mBeanExporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("jmxApplication:name=MessageManageOperation", messageManageOperation);
        mBeanExporter.setBeans(beans);
        return mBeanExporter;
    }

}
