package entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Show extends PanacheEntity {

    String showName;

    String venue;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<TicketKind> ticketKinds;


}
