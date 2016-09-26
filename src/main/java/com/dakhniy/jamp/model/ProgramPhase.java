package com.dakhniy.jamp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class ProgramPhase {
    private long id;
    private String name;
    private MentorshipProgram program;
    private Person curator;
}
