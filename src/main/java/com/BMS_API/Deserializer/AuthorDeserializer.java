package com.BMS_API.Deserializer;

import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AuthorDeserializer extends StdDeserializer<author> {

    public AuthorDeserializer() {
        this(null);
    }

    public AuthorDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public author deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").asText();
        String biography = node.get("biography").asText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dob = null;
        if(node.get("dateOfBirth")!=null) {
            try {
                dob = formatter.parse(node.get("dateOfBirth").asText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return new author(name,dob,biography,new HashSet<>());
    }
}
