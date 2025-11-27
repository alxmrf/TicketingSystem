package knt.org.orderService.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import knt.org.orderService.dto.input.ClientInputDto;
import knt.org.orderService.entity.Client;

@ApplicationScoped
public class ClientService {


    @Transactional
    public void createNewClient(ClientInputDto dto){
        var newClient = new Client(dto);
        newClient.persist();
    }

}
