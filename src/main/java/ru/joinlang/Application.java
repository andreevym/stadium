package ru.joinlang;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.joinlang.config.SecurityConfiguration;

@SpringBootApplication
@Import(value = {SecurityConfiguration.class})
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("Application is running!");
        SpringApplication.run(Application.class, args);
    }
}