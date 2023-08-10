package com.example.sonarqubetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SonarQubeTestClass {
    @GetMapping("/sonarqube")
    public String getData(){
        return "THIS IS SONARQUBE TEST CLASS";
    }
}
