package com.dakhniy.jamp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class MentorshipProgram {
    private long id;
    private String name;
    private String officeLocation;
    private LocalDate startDate;
    private LocalDate endDate;
}
