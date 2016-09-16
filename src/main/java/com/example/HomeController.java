package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private GreetingService service;

    @Autowired
    public HomeController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String home(@RequestParam(value = "name", required = false) String name) {
        if ( name == null ) return service.greet();
        return service.greet(name);
    }

}
