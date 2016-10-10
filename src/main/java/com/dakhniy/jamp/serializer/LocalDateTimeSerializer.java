package com.dakhniy.jamp.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sergiy_Dakhniy on 9/28/2016.
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Value("${jamp.pattern.dateTime}")
    private String dateTimeFormat;

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String dateString = localDateTime.format(DateTimeFormatter.ofPattern(dateTimeFormat));
        jsonGenerator.writeObject(dateString);
    }
    public LocalDateTimeSerializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
