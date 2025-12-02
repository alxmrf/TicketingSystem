package knt.org.orderService.messaging.events;

import knt.org.orderService.entity.Order;

public record OrderPaymentEvent(
        String cpf,
        String status,
        Double price,
        Long orderId
) {

    public OrderPaymentEvent(Order newOrder){
        this(newOrder.getBuyer().getCpf(), newOrder.getStatus(), newOrder.getPrice(),newOrder.getId());
    }
}
