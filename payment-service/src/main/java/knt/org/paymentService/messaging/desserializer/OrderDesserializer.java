package knt.org.paymentService.messaging.desserializer;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

import knt.org.paymentService.domain.entity.event.OrderEvent;

public class OrderDesserializer extends ObjectMapperDeserializer<OrderEvent> {

    public OrderDesserializer(){
        super(OrderEvent.class);
    }

}
