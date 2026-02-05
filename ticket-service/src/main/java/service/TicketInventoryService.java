package service;

import entity.Show;
import entity.TicketKind;
import exception.TicketSoldOutException;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.TicketKindRepository;

import javax.naming.InsufficientResourcesException;

@ApplicationScoped
public class TicketInventoryService {

    @Inject
    TicketKindRepository repository;

    @Transactional
    public void verifyStockAndReserveTicket(int amount,String showName, String ticketKind){
        var ticket = repository.find("show.showName=:showName and ticketKind=:ticketKind", Parameters.with("showName",showName)
                .and("ticketKind",ticketKind)).withLock(LockModeType.PESSIMISTIC_WRITE).firstResultOptional();

        if(ticket.isEmpty()){
            throw new NotFoundException("The specified ticket was not found");
        }
        if(ticket.get().getAmountLeft() >= amount){
            ticket.get().setAmountLeft(ticket.get().getAmountLeft() - amount);
        }
        else{
            throw new TicketSoldOutException("The amount of tickets left is not enough to complete the request");
        }
    }


}
