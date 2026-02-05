package messaging.publisher;

import jakarta.inject.Inject;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import knt.org.ticketingProjectSchemas.ticket.TicketEnvelope;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

public class TicketEventPublisher {



    private static final Logger LOG =  Logger.getLogger(TicketEventPublisher.class);

    @Inject
    @Channel("ticket-topic")
    Emitter<TicketEnvelope> ticketEnvelopeEmitter;

    public void publishTicketReservedEvent(TicketEnvelope ticketEnvelope) {
        ticketEnvelopeEmitter.send(ticketEnvelope);
    }
    public void publishTicketRanOutEvent(TicketEnvelope ticketEnvelope) {
        ticketEnvelopeEmitter.send(ticketEnvelope);
    }
}




