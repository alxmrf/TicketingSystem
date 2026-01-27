package messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import knt.org.ticketingProjectSchemas.order.OrderEventType;
import messaging.handler.OrderHandler;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.hibernate.query.Order;

@ApplicationScoped
public class OrderConsumer {

    @Inject
    OrderHandler handler;

    @Incoming("order-requests")
    public void consumeOrderTopic(OrderEnvelope orderEnvelope){
        switch (orderEnvelope.getEventType()){
            case ORDER_CREATED -> this.dispatchOrderCreatedEvent(orderEnvelope);
            case ORDER_CANCELLED -> this.dispatchOrderCancelledEvent(orderEnvelope);
        }

    }

    public void dispatchOrderCreatedEvent(OrderEnvelope orderCreatedEnvelope){

    }

    public void dispatchOrderCancelledEvent(OrderEnvelope orderCancelledEnvelope){

    }

}
