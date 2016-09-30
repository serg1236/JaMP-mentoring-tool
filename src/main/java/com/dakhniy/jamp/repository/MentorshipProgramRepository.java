package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.MentorshipProgram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface MentorshipProgramRepository extends CrudRepository<MentorshipProgram, Long> {
    List<MentorshipProgram> findAll();
}
