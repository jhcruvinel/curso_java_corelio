package com.exercicio.laboratorio1.servicos;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.laboratorio1.entidades.Greeting2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Greeting2Controller {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting2")
    public HttpEntity<Greeting2> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting2 greeting = new Greeting2(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(Greeting2Controller.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
