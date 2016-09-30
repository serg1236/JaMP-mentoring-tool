package com.dakhniy.jamp.serializer;

import com.dakhniy.jamp.model.PrimarySkill;
import com.dakhniy.jamp.repository.PrimarySkillRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

/**
 * Created by Sergiy_Dakhniy on 9/27/2016.
 */
public class StringToPrimarySkillDeserializer extends JsonDeserializer<PrimarySkill> {

    @Autowired
    private PrimarySkillRepository primarySkillRepository;

    public StringToPrimarySkillDeserializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public PrimarySkill deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String primarySkillName = node.asText();
        return primarySkillRepository.findOneByName(primarySkillName);
    }
}
