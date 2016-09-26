package com.dakhniy.jamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @ResponseBody
    @RequestMapping("/test.rest")
    public String test() {
        return "Hello world!";
    }

    @RequestMapping("/test")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Heloooooo!!!!");
        return "hello";
    }

}
