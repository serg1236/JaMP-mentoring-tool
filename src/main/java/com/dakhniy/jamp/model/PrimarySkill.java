package com.dakhniy.jamp.model;

import com.dakhniy.jamp.serializer.PrimarySkillToStringSerializer;
import com.dakhniy.jamp.serializer.StringToPrimarySkillDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
@Entity
@JsonDeserialize(using = StringToPrimarySkillDeserializer.class)
@JsonSerialize(using = PrimarySkillToStringSerializer.class, as = String.class)
public class PrimarySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public PrimarySkill(String name) {
        this.name = name;
    }
}
