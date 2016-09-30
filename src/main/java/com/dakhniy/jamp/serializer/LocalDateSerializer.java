package com.dakhniy.jamp.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sergiy_Dakhniy on 9/28/2016.
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Value("${jamp.pattern.date:MM/dd/yyyy}")
    private String dateFormat;

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String dateString = localDate.format(DateTimeFormatter.ofPattern(dateFormat));
        jsonGenerator.writeObject(dateString);
    }
    public LocalDateSerializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
