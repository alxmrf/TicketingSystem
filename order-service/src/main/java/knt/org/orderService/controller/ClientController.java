package knt.org.orderService.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import knt.org.orderService.dto.input.ClientInputDto;
import knt.org.orderService.entity.Client;
import knt.org.orderService.service.ClientService;

import java.awt.*;

@Path("/client")
@ApplicationScoped
public class ClientController {

    private ClientService service;
    public ClientController(ClientService service){
        this.service=service;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createClient(ClientInputDto newClient){
        try{
            this.service.createNewClient(newClient);
            return Response.ok("Added").build();
        }catch (Exception e){
            System.out.println(e);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}
