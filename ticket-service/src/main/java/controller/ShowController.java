package controller;


import dto.CreateShowDto;
import entity.Show;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;
import service.ShowService;

@ApplicationScoped
@Path("/show")
public class ShowController {

    @Inject
    ShowService service;

    @POST
    @Path("")
    public Response createShow(CreateShowDto createDTO){
        this.service.createNewShow(createDTO);
        return Response.status(201).build();
    }

    @GET
    @Path("")
    public Response findShow(@RestPath String showName){
        return Response.ok(this.service.findShow(showName)).build();
    }




}



