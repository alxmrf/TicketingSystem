package knt.org.orderService.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Client;
import knt.org.orderService.entity.Order;
import knt.org.orderService.exceptions.InvalidOrderException;
import knt.org.orderService.mapper.OrderMapper;

@ApplicationScoped
public class OrderService {

    @Inject
    ClientService clientService;

    @Inject
    OrderMapper mapper;



    public Order createOrder(OrderRequest orderCreateDto){
        var client = this.clientService.findClient(orderCreateDto.cpfClient());
        this.verifyOrder(orderCreateDto);
        return this.mapper.createOrder(orderCreateDto,client);
    }


    public void verifyOrder(OrderRequest orderCreateDto){

        if(orderCreateDto.ticketQuantity() > 5){
            throw new InvalidOrderException("The amount of tickets in a order can`t be more than 5");
        }
    }





}
