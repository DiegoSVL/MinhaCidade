package com.example.minhacidade.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
    @RequestMapping("/hello/{nome}")
    public String hello(@PathVariable("nome") String nome){
        var sb  = new StringBuilder("Hello");
        if (StringUtils.hasText(nome)){
            sb.append(" ").append(nome);
        }
        return sb.toString();
    }
}
