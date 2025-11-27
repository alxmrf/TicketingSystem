package knt.org.orderService.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
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
    @ManyToOne
            @JoinColumn(name = "clientCpf")
    Client buyer;


}
