package messaging.handler;

import jakarta.inject.Inject;
import knt.org.ticketingProjectSchemas.order.OrderCreatedPayload;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import service.TicketInventoryService;

public class OrderHandler {


    @Inject
    TicketInventoryService service;

    public void handleOrderCreatedEvent(OrderEnvelope orderCreatedEnvelope){
        OrderCreatedPayload payload = (OrderCreatedPayload) orderCreatedEnvelope.getPayload();
        this.service.verifyStockAndReserveTicket();
    }

}
