package com.example.fleetApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping(value = {"/index", "/"})
    public String homePage() {
        return "index";
    }
}
