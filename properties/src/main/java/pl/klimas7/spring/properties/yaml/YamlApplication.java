package pl.klimas7.spring.properties.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YamlApplication implements CommandLineRunner {

    @Autowired
    private YAMLConfig yamlConfig;

    public static void main(String[] args) {
        SpringApplication.run(YamlApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("using environment: " + yamlConfig.getEnvironment());
        System.out.println("name: " + yamlConfig.getName());
        System.out.println("servers: " + yamlConfig.getServers());
    }
}
