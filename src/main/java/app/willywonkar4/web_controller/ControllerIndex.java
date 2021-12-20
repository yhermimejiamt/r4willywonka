package app.willywonkar4.web_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import app.willywonkar4.service.ServiceUser;

public class ControllerIndex {
    
    @Autowired
    private ServiceUser service;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/perfilAdmin")
    public String homePage() {
        return "perfilAdmin";
    }
}
