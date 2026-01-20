package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TicketKind {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    Show show;

    String ticketKind;

    Integer amountLeft;

    @Column(precision = 12)
    BigDecimal price;




}
