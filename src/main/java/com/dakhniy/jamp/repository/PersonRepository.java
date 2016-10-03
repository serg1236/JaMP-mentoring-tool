package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findByName(String name);
    List<Person> findAll();
    Person findOneByEmail(String email);
}
