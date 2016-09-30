package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.enumeration.EmployeeLevel;
import com.dakhniy.jamp.serializer.LocalDateDeserializer;
import com.dakhniy.jamp.serializer.LocalDateSerializer;
import com.dakhniy.jamp.serializer.PrimarySkillToStringSerializer;
import com.dakhniy.jamp.serializer.StringToPrimarySkillDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false, unique = true)
    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private EmployeeLevel level;

    @ManyToOne
    @Valid
    private PrimarySkill primarySkill;

    @ManyToOne
    @Valid
    private Person manager;

    @Column(nullable = false)
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;
}
