package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobTitles")
public class JobTitleController {
    @GetMapping
    public String getJobTitles() {
        return "job-titles";
    }
}
