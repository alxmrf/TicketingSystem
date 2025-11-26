package knt.org.paymentService.messaging.desserializer;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

import knt.org.paymentService.dto.event.OrderEvent;
import knt.org.paymentService.entity.Order;

public class OrderDesserializer extends ObjectMapperDeserializer<OrderEvent> {

    public OrderDesserializer(){
        super(OrderEvent.class);
    }

}
