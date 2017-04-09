package config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
