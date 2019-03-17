package se.claudiastenberg.smsprogram.resource;

import org.springframework.stereotype.Component;
import se.claudiastenberg.smsprogram.model.Appoinment;
import se.claudiastenberg.smsprogram.service.AppoinmentService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.concurrent.atomic.AtomicLong;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@Resource
@Path("appoinment")
@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AppoinmentResource {

    private final AppoinmentService appoinmentService;
    private static final AtomicLong ids = new AtomicLong(1000);

    public AppoinmentResource(AppoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    // CREATE
    @POST
    public Response createAppoinment(Appoinment appoinment) {
        Long id = ids.incrementAndGet();
        Appoinment newAppoinment = new Appoinment(id, appoinment.getUser(), appoinment.getCause());
        appoinmentService.addAppoinment(newAppoinment);

        return Response.status(CREATED).header("Location", "appoinment/" + id).build();
    }

    // READ
    @GET
    @Path("{id}")
    public Response getAppoinment(@PathParam("id") Long id) {
        return appoinmentService.getByID(id).map(Response::ok).orElse(Response.status(NOT_FOUND)).build();
    }
    @GET
    public Iterable<Appoinment> getAll(){
        return appoinmentService.getallAppoinments();
    }

    //DELETE
    @DELETE
    @Path("{id}")
    public Response deleteAppoinment(@PathParam("id") Long id) {
        appoinmentService.deleteAppoinment(id);
        return Response.status(OK).build();
    }


}
