package se.claudiastenberg.smsprogram.resource;


import org.springframework.stereotype.Component;
import se.claudiastenberg.smsprogram.model.User;
import se.claudiastenberg.smsprogram.service.UserService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@Resource
@Path("users")
@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class UserResource {

    private final UserService service; //Denna hjälper att spara i SQsL
    private static final AtomicLong ids = new AtomicLong(1000);

    public UserResource(UserService service) {
        this.service = service;
    }

    @POST
    public Response createUser(User user){
        service.addUser(user);
        return Response.ok().build();
    }

    // READ
    @GET
    @Path("{personald}")
    public Response getUser(@PathParam("personald") int personald) {
        return Response.ok(service.getUsers(personald)).build();
    }
    @GET
    public Iterable<User> getAll(){
        return service.getAllUsers();
    }

    @PUT
    @Path("{personalID}")
    public Response updateUser(@PathParam("personalID") int personalID, User user) {
        service.bookAppoinment(personalID, user);
        return Response.noContent().build();
    }

    //DELETE
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        service.deleteUser(id);
        return Response.status(OK).build();
    }

}

