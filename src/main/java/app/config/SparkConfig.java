package app.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
public class SparkConfig {
    @Autowired(required = false)
    private List<Spark> sparks = new ArrayList<>();

    @Bean
    CommandLineRunner sparkRunner() {
        return args -> sparks.stream().forEach( spark -> spark.register());
    }
}
