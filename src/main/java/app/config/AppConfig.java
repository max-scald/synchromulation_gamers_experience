package app.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"app"})
public class AppConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper(){return new DozerBeanMapper();}

}
