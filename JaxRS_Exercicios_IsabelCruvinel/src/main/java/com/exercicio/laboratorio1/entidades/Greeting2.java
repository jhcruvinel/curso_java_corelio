package com.exercicio.laboratorio1.entidades;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting2 extends ResourceSupport {

    private final String content;

    @JsonCreator
    public Greeting2(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
