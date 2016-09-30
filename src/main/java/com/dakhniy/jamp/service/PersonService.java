package com.dakhniy.jamp.service;

import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.repository.MentorshipGroupRepository;
import com.dakhniy.jamp.repository.PersonRepository;
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
    private MentorshipGroupRepository mentorshipGroupRepository;

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public Set<Person> getMenteesByMentor(Person mentor) {
        return mentorshipGroupRepository.findByMentor(mentor).getMentees();
    }
}
