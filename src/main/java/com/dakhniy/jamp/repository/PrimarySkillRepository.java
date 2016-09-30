package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.PrimarySkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface PrimarySkillRepository extends CrudRepository<PrimarySkill, Long>{
    PrimarySkill findOneByName(String name);
}
