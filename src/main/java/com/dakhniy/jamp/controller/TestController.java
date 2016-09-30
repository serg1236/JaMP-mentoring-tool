package com.dakhniy.jamp.controller;

import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private PersonRepository personRepository;

    @ResponseBody
    @RequestMapping("/test.rest")
    public String test() {
        Person p1 = new Person();
        p1.setBirthDate(LocalDate.of(1994, 12, 26));
        p1.setName("Sergiy Dakhniy");
        personRepository.save(p1);
        return "Hello world!";
    }

    @RequestMapping("/test")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Heloooooo!!!!");
        return "hello";
    }

}
