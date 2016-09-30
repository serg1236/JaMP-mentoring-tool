package com.dakhniy.jamp.serializer;

import com.dakhniy.jamp.model.PrimarySkill;
import com.dakhniy.jamp.repository.PrimarySkillRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
public class PrimarySkillToStringSerializer extends JsonSerializer<PrimarySkill> {


    @Override
    public void serialize(PrimarySkill primarySkill, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeObject(primarySkill.getName());
    }
}
