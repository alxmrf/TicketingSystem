package knt.org.orderService.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.inject.Default;
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

    @Column(columnDefinition = "DEFAULT 'ORDER_CREATED'")
    String status;

    String showName;
    Double price;
    String ticketKind;
    Integer ticketQuantity;

    @ManyToOne
    @JoinColumn(name = "clientCpf")
    Client buyer;


    public Order(OrderRequest newOrder,String status){
        this.status = status;
        this.showName = newOrder.showName();
        this.price = newOrder.price();
        this.ticketQuantity = newOrder.ticketQuantity();
        this.buyer = Client.findById(newOrder.cpfClient());
    }
}
