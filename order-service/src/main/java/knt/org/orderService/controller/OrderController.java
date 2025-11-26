package Controller.knt.org.controller;

import Controller.knt.org.entity.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
@Path("/order")
public class OrderController {

    @Channel("order-requests")
    Emitter<Order> orderEmitter;

    @POST
    @Path("/create-order")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Order newOrder){
        try {
            newOrder.setId(UUID.randomUUID().toString());
            System.out.println(newOrder);
            this.orderEmitter.send(newOrder);
            System.out.println("Ticket enviado");
            return Response.status(Response.Status.ACCEPTED).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }




}
