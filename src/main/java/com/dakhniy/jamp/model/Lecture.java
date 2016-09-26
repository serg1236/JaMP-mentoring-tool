package com.dakhniy.jamp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Sergiy_Dakhniy on 9/26/2016.
 */
@Data
@NoArgsConstructor
public class Lecture {
    private long id;
    private String topic;
    private int minutesDuration;
    private LocalDateTime scheduledTime;
    private Person lector;
    private ProgramPhase phase;
}
