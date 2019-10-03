package com.exercicio.home_banking;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.exercicio.home_banking.services.COAFResource;

@Configuration
@ApplicationPath("v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(COAFResource.class);
    }
}