package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
