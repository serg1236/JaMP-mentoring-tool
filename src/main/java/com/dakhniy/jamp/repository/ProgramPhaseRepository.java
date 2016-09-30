package com.dakhniy.jamp.repository;

import com.dakhniy.jamp.model.ProgramPhase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
@Repository
public interface ProgramPhaseRepository extends CrudRepository<ProgramPhase, Long> {
}
