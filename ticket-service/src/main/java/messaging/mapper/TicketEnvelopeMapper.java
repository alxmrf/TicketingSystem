package messaging.mapper;

import entity.TicketKind;
import knt.org.ticketingProjectSchemas.ticket.TicketEnvelope;
import knt.org.ticketingProjectSchemas.ticket.TicketEventType;
import knt.org.ticketingProjectSchemas.ticket.TicketRanOutPayload;
import knt.org.ticketingProjectSchemas.ticket.TicketReservedPayload;

public class TicketEnvelopeMapper {



    public static TicketEnvelope createTicketReservedEnvelope(int amount, Long orderId, String ticketKind,String showName){

        var ticketEnvelope =  new TicketEnvelope();
        ticketEnvelope.setEventType(TicketEventType.TICKET_RESERVED);
        ticketEnvelope.setOrderId(orderId);

        var ticketReservedPayload =  new TicketReservedPayload();
        ticketReservedPayload.setQuantity(amount);
        ticketReservedPayload.setShowName(showName);
        ticketReservedPayload.setTicketKind(ticketKind);

        ticketEnvelope.setPayload(ticketReservedPayload);
        return ticketEnvelope;
    }

    public static TicketEnvelope createTicketRanOutEnvelope(Long orderId, String ticketKind,String showName){
        var ticketEnvelope =  new TicketEnvelope();
        ticketEnvelope.setEventType(TicketEventType.TICKET_RAN_OUT);
        ticketEnvelope.setOrderId(orderId);

        var ticketRanOutPayload =  new TicketRanOutPayload();
        ticketRanOutPayload.setShowName(showName);
        ticketRanOutPayload.setTicketKind(ticketKind);

        ticketEnvelope.setPayload(ticketRanOutPayload);
        return ticketEnvelope;
    }

}
