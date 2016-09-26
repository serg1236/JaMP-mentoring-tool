package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.Person;
import com.dakhniy.jamp.model.enumeration.GroupStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class MentorshipGroup {
    private long id;
    private Person mentor;
    private Set<Person> mentees;
    private GroupStatus status;
    private ProgramPhase phase;
}
