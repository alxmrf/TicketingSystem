package knt.org.orderService.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Client;
import knt.org.orderService.entity.Order;
import knt.org.orderService.exceptions.InvalidOrderException;
import knt.org.orderService.mapper.OrderMapper;

import javax.swing.text.html.parser.Entity;

@ApplicationScoped
public class OrderService {

    @Inject
    EntityManager em;

    @Inject
    ClientService clientService;

    @Inject
    OrderMapper mapper;


    @Transactional
    public Order createOrder(OrderRequest orderCreateDto){
        var client = this.clientService.findClient(orderCreateDto.cpfClient());
        this.verifyOrder(orderCreateDto);
        var order = this.mapper.createOrder(orderCreateDto,client);
        order.setId(null);
        Order.persist(order);
        em.flush();
        em.refresh(order);

        System.out.println(order);
        return order;
    }


    public void verifyOrder(OrderRequest orderCreateDto){

        if(orderCreateDto.ticketQuantity() > 5){
            throw new InvalidOrderException("The amount of tickets in a order can`t be more than 5");
        }
    }





}
