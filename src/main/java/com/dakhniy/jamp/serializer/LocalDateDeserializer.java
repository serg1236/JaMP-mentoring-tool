package com.dakhniy.jamp.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.SpringProperties;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by Sergiy_Dakhniy on 9/28/2016.
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

    @Value("${jamp.pattern.date:MM/dd/yyyy}")
    private String dateFormat;

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String dateString = node.asText();
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(dateFormat));
    }

    public LocalDateDeserializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
