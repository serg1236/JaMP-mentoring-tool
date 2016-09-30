package com.dakhniy.jamp.controller;

import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.model.PrimarySkill;
import com.dakhniy.jamp.repository.PersonRepository;
import com.dakhniy.jamp.repository.PrimarySkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Controller
@RequestMapping("/user")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PrimarySkillRepository primarySkillRepository;

    @PostMapping
    @ResponseBody
    public Person save(@RequestBody @Valid Person person) {
        personRepository.save(person);
        return person;
    }

    @GetMapping("/{email:.+}")
    @ResponseBody
    public Person getByEmail(@PathVariable String email) {
        return personRepository.findOneByEmail(email);
    }
}
