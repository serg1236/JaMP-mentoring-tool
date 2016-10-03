package com.dakhniy.jamp.service;

import com.dakhniy.jamp.exception.ItemExistsException;
import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.model.PrimarySkill;
import com.dakhniy.jamp.repository.MentorshipGroupRepository;
import com.dakhniy.jamp.repository.PersonRepository;
import com.dakhniy.jamp.repository.PrimarySkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PrimarySkillRepository primarySkillRepository;

    @Autowired
    private MentorshipGroupRepository mentorshipGroupRepository;

    public Set<Person> getMenteesByMentor(Person mentor) {
        return mentorshipGroupRepository.findByMentor(mentor).getMentees();
    }

    public Set<PrimarySkill> getPrimarySkills() {
        return primarySkillRepository.findAll();
    }

    public Person createPerson(Person person) {
        if(exists(person)) {
            throw new ItemExistsException();
        } else {
            return personRepository.save(person);
        }
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.delete(id);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    private boolean exists(Person person) {
        return (person.getId() != null && personRepository.exists(person.getId())) ||
                personRepository.findOneByEmail(person.getEmail()) != null;
    }
}
