package knt.org.orderService.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import knt.org.orderService.dto.input.OrderRequest;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String status;
    String showName;
    Double price;
    Integer ticketQuantity;
    @ManyToOne
            @JoinColumn(name = "clientCpf")
    Client buyer;


    public Order(OrderRequest newOrder,String status){
        this.status = status;
        this.showName = newOrder.showName();
        this.price = newOrder.price();
        this.ticketQuantity = newOrder.quantity();
        this.buyer = Client.findById(newOrder.cpfClient());
    }
}
