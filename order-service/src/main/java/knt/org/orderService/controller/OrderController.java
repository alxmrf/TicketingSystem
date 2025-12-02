package knt.org.orderService.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Order;
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
    public Response createOrder(OrderRequest newOrder){

    }




}
