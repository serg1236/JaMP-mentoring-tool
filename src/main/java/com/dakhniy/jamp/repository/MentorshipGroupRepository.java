package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.MentorshipGroup;
import com.dakhniy.jamp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface MentorshipGroupRepository extends CrudRepository<MentorshipGroup, Long> {

    MentorshipGroup findByMentor(Person mentor);
}
