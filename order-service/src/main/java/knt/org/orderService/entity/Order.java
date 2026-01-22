package knt.org.orderService.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.*;
import knt.org.orderService.dto.input.OrderRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "varchar(255) DEFAULT 'ORDER_CREATED'")
    String status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    Instant createdAt;
    String showName;
    Double price;
    String ticketKind;
    Integer ticketQuantity;

    @ManyToOne
    @JoinColumn(name = "clientCpf")
    Client buyer;

    @PrePersist
    public void setParameters(){
        this.setId(null);
    }

    public Order(OrderRequest newOrder,String status){
        this.status = status;
        this.showName = newOrder.showName();
        this.price = newOrder.price();
        this.ticketQuantity = newOrder.ticketQuantity();
        this.buyer = Client.findById(newOrder.cpfClient());
    }
}
