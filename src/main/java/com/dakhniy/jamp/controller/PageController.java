package com.dakhniy.jamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sergiy_Dakhniy on 10/3/2016.
 */
@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/programs")
    public String programs() {
        return "programs";
    }

    @GetMapping
    public String defaultPage(){
        return "redirect:/pages/users";
    }
}
