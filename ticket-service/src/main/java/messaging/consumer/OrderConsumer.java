package messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OrderConsumer {


    @Incoming("order-requests")
    public void consumeOrderTopic(OrderEnvelope orderEnvelope){
        System.out.println(orderEnvelope);
    }

}
