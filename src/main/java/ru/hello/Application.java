package ru.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hello.config.SecurityConfig;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.hello.controller")
@Import(SecurityConfig.class)
public class Application {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        System.out.println("bean provided by Spring Boot:");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);

        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.printf("%s : %s %n", beanDefinitionNames[i], i);
        }

        //new Main().init(null); hibernate somewhere
    }
}