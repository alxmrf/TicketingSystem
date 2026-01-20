package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor


public class Show {

    @Id
    Long showId;

    String showName;

    String venue;

    @OneToMany(mappedBy = "show")
    List<TicketKind> ticketKinds;






}
