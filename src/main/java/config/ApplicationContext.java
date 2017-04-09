package config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Java based application context configuration class.
 * <p>
 * Including data source and transaction manager configuration.
 */
@ComponentScan(basePackageClasses = com.PackageInfo.class)
@Configuration
public class ApplicationContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
