package com.dakhniy.jamp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String topic;
    @Column(nullable = false)
    private int minutesDuration;
    @Column(nullable = false)
    private LocalDateTime scheduledTime;
    @ManyToOne
    @Valid
    private Person lector;
    @ManyToOne
    @JoinColumn(nullable = false)
    @Valid
    private ProgramPhase phase;
}
