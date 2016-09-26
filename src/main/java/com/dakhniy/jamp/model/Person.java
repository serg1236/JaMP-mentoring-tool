package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.enumeration.EmployeeLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private String email;
    private EmployeeLevel level;
    private PrimarySkill primarySkill;
    private Person manager;
    private LocalDate birthDate;
}
