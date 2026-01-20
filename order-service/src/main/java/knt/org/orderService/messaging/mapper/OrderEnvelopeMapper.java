package knt.org.orderService.messaging.mapper;

import knt.org.orderService.entity.Order;
import knt.org.ticketingProjectSchemas.order.OrderCreatedPayload;
import knt.org.ticketingProjectSchemas.order.OrderEnvelope;
import knt.org.ticketingProjectSchemas.order.OrderEventType;

import java.time.Instant;
import java.time.LocalDateTime;

public class OrderEnvelopeMapper {


     public static  OrderEnvelope createNewOrderEvent(Order order){
         var newOrderEvent =  new OrderEnvelope();
         newOrderEvent.setOrderId(order.getId());
         newOrderEvent.setEventType(OrderEventType.ORDER_CREATED);
         newOrderEvent.setOrderDate(Instant.from(LocalDateTime.now()));

         var payload =  new OrderCreatedPayload();


         payload.setQuantity(order.getTicketQuantity());
         payload.setUserCpf(order.getBuyer().getCpf());
         payload.setShowName(order.getShowName());
         payload.setTicketKind(order.getTicketKind());
         newOrderEvent.setPayload(payload);
         return newOrderEvent;
     }

}
