package knt.org.paymentService.messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import knt.org.paymentService.dto.event.OrderEvent;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OrderProcessor {

    @Incoming("orders-in")
    @Transactional
    public void process(OrderEvent newOrder){
        System.out.println(newOrder);
    }

}
