package com.project.blogforum.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }
}
