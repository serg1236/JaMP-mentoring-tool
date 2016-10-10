package com.dakhniy.jamp.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sergiy_Dakhniy on 9/28/2016.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>{

    @Value("${jamp.pattern.dateTime}")
    private String dateTimeFormat;

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String dateString = node.asText();
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(dateTimeFormat));
    }

    public LocalDateTimeDeserializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
