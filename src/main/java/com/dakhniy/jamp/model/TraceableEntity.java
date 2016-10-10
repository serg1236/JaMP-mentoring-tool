package com.dakhniy.jamp.model;


import com.dakhniy.jamp.serializer.LocalDateTimeDeserializer;
import com.dakhniy.jamp.serializer.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by Sergiy_Dakhniy on 10/6/2016.
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class TraceableEntity {
    private String lastModifiedBy;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lastModified;
    private String createdBy;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime created;
}
