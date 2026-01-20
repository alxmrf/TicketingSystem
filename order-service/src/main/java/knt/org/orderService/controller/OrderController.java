package knt.org.orderService.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Order;
import knt.org.orderService.messaging.publisher.OrderEventPublisher;
import knt.org.orderService.service.OrderService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
@Path("/order")
public class OrderController {

    @Channel("order-requests")
    Emitter<Order> orderEmitter;

    @Inject
    OrderService service;

    @Inject
    OrderEventPublisher orderPublisher;

    @POST
    @Path("/create-order")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderRequest createOrderDto){
        var newOrder = service.createOrder(createOrderDto);
        orderPublisher.publishOrderCreatedEvent(newOrder);
        return Response.ok("Order created and will be processed").build();
    }




}
