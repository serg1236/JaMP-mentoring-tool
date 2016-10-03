package com.dakhniy.jamp.controller;

import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.model.PrimarySkill;
import com.dakhniy.jamp.repository.PersonRepository;
import com.dakhniy.jamp.repository.PrimarySkillRepository;
import com.dakhniy.jamp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseBody
    public Person save(@RequestBody @Valid Person person) {
       personService.createPerson(person);
       return person;
    }

    @PutMapping
    @ResponseBody
    public Person update(@RequestBody @Valid Person person) {
        personService.updatePerson(person);
        return person;
    }

    @GetMapping
    @ResponseBody
    public List<Person> getAll() {
        return personService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/skills")
    @ResponseBody
    public Set<PrimarySkill> getPrimarySkills() {
        return personService.getPrimarySkills();
    }
}
