package ru.hello.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
