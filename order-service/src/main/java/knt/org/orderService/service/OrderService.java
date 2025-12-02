package knt.org.orderService.service;


import jakarta.enterprise.context.ApplicationScoped;
import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Order;
import knt.org.orderService.exceptions.InvalidOrderException;

@ApplicationScoped
public class OrderService {

    ClientService clientService;

    public void verifyOrder(OrderRequest newOrder){
        this.clientService.verifyClient(newOrder.cpfClient());
        if(newOrder.quantity()>5){
            throw new InvalidOrderException("The amount of tickets in a order can`t be more than 5");
        }

        var order = new Order(newOrder, "CREATED");
        order.persist();






    }





}
