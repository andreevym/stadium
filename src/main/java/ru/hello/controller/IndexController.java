package ru.hello.controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {

    public static final String MSG = "Boot IndexController";
    @RequestMapping("/")
    public String index() {
        return MSG;
    }
}
