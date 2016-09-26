package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.enumeration.PersonStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class PhaseParticipation {
    private long id;
    private Person person;
    private ProgramPhase phase;
    private PersonStatus status;
}
