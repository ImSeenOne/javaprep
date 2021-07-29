package com.enroutesystems.annotationExamples;

import com.enroutesystems.annotationExamples.Exceptions.JsonSerializationException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class Process {
    public static void main (String[] args) throws JsonSerializationException {
        Person person = new Person("Joyner", "Lucas", "29");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        log.info("jsonString: " + jsonString);
    }

}
