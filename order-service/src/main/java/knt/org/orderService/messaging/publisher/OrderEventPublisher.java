package knt.org.orderService.messaging.publisher;


import jakarta.inject.Inject;
import knt.org.orderService.entity.Order;
import knt.org.orderService.messaging.mapper.OrderEnvelopeMapper;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

public class OrderEventPublisher {


    private static final Logger LOG =  Logger.getLogger(OrderEventPublisher.class);

    @Inject
    Emitter<OrderEnvelope> orderEnvelopeEmitter;


    public void publishOrderCreatedEvent(Order order){
        var newEvent = OrderEnvelopeMapper.createNewOrderEvent(order);
        orderEnvelopeEmitter.send(newEvent);
    }





}
