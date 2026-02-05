package messaging.handler;

import exception.TicketSoldOutException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import knt.org.ticketingProjectSchemas.order.OrderCreatedPayload;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import messaging.mapper.TicketEnvelopeMapper;
import messaging.publisher.TicketEventPublisher;
import org.jboss.logging.Logger;
import service.TicketInventoryService;

import javax.naming.InsufficientResourcesException;

@ApplicationScoped
public class OrderHandler {


    @Inject
    TicketInventoryService service;

    @Inject
    TicketEventPublisher publisher;

    private static final Logger LOG = Logger.getLogger(OrderHandler.class);
    
    

    public void handleOrderCreatedEvent(OrderEnvelope orderCreatedEnvelope){
        OrderCreatedPayload payload = (OrderCreatedPayload) orderCreatedEnvelope.getPayload();
        try {

            this.service.verifyStockAndReserveTicket(payload.getQuantity(), payload.getShowName().toString(), payload.getTicketKind().toString());
            this.publishTicketReservedEvent(orderCreatedEnvelope,payload);

        } catch (TicketSoldOutException e) {

            this.publishTicketRanOutEvent(orderCreatedEnvelope,payload);
            LOG.infof("INSUFFICIENT STOCK: Ticket '%s' for Show '%s' could not be reserved.",
                    payload.getTicketKind(),
                    payload.getShowName());
            
        }
    }

    private void publishTicketRanOutEvent(OrderEnvelope orderCreatedEnvelope,OrderCreatedPayload payload  ){

        var envelope = TicketEnvelopeMapper.createTicketRanOutEnvelope(
                orderCreatedEnvelope.getOrderId(),
                payload.getShowName().toString(),
                payload.getTicketKind().toString());

        this.publisher.publishTicketRanOutEvent(envelope);

    }

    private void publishTicketReservedEvent(OrderEnvelope orderCreatedEnvelope,OrderCreatedPayload payload  ){

        var envelope = TicketEnvelopeMapper.createTicketReservedEnvelope(
                payload.getQuantity(),
                orderCreatedEnvelope.getOrderId(),
                payload.getShowName().toString(),
                payload.getTicketKind().toString());

        this.publisher.publishTicketReservedEvent(envelope);

    }


}
