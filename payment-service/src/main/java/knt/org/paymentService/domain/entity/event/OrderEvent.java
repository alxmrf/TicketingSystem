package knt.org.paymentService.domain.entity.event;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderEvent {

    String id;
    String clientName;
    String status;
    String showName;
    Double price;

}
