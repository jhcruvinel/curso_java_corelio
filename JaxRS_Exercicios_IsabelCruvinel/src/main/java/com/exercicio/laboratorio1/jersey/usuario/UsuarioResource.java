package com.exercicio.laboratorio1.jersey.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercicio.laboratorio1.entidades.Usuario;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;



@Component
@Path("user")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuarios() {
        List<Usuario> allUsuarios = usuarioService.getAllUsers();
        return Response.ok(allUsuarios).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUsuario(@PathParam("id") int id) {
        Usuario usuario = usuarioService.getUserById(id);
        return Response.ok(usuario).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario usuario) {
        usuarioService.addUser(usuario);
        return Response.created(URI.create("/" + usuario.getId())).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateUsuario (@PathParam("id") int id, Usuario usuario) {
        usuarioService.updateUser(id, usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUsuario(@PathParam("id") int id) {
        usuarioService.removeUser(id);
        return Response.noContent().build();
    }

}