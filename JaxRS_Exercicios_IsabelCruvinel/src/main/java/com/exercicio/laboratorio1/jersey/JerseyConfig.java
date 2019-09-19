package com.exercicio.laboratorio1.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.exercicio.laboratorio1.jersey.book.BookResource;
import com.exercicio.laboratorio1.jersey.usuario.UsuarioResource;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(BookResource.class);
        register(UsuarioResource.class);
    }
}