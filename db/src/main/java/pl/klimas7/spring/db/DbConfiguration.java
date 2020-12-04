package pl.klimas7.spring.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    @Bean
    @Profile("dev")
    public DataSource devDS() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:scripts/h2-schema.sql")
                .addScript("classpath:scripts/test-data.sql")
                .build();
    }
}
