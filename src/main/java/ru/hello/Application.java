package ru.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.hello.controller")
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        System.out.println("bean provided by Spring Boot:");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);

        for (int i = 0; i< beanDefinitionNames.length; i++) {
            System.out.printf("%s : %s %n", beanDefinitionNames[i], i);
        }
        
        //new Main().init(null);
    }

}