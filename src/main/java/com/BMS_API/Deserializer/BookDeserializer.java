package com.BMS_API.Deserializer;

import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

public class BookDeserializer extends StdDeserializer<book> {

    public BookDeserializer() {
        this(null);
    }

    public BookDeserializer(Class<?> vc) {
        super(vc);
    }
    @Override
    public book deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String title = node.get("title").asText();
        String isbn = node.get("isbn").asText();
        String description = node.get("description").asText();
        HashSet authors=new HashSet<author>();
        for(int i=0;i<node.get("authors").size();i++)
        {
            JsonNode node1 =node.get("authors").get(i);
            String name = node1.get("name").asText();
            String biography = node1.get("biography").asText();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date dob = null;
            if(node1.get("dateOfBirth")!=null) {
                try {
                    dob = formatter.parse(node1.get("dateOfBirth").asText());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            authors.add(new author(name,dob,biography,new HashSet<>()));
        }
        return new book(title,isbn,description,authors);
    }
}
