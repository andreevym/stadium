package ru.joinlang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class TestUI {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TestUI.class).properties(
                "server.port=9999", "security.basic.enabled=false").run(args);
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/test.html";
    }

}
