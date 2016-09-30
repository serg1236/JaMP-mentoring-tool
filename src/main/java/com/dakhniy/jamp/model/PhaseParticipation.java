package com.dakhniy.jamp.model;

import com.dakhniy.jamp.model.enumeration.PersonStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
@Entity
public class PhaseParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    @Valid
    private Person mentee;
    @ManyToOne
    @JoinColumn(nullable = false)
    @Valid
    private ProgramPhase phase;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonStatus status;
}
