package Controller.knt.org.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    String id;
    String clientName;
    String status;
    String showName;
    Double price;
}
