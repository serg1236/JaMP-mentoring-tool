package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.enumeration.GroupStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
@Entity
public class MentorshipGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Valid
    private Person mentor;
    @OneToMany
    private Set<Person> mentees;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GroupStatus status;
    @ManyToOne
    private ProgramPhase phase;
}
