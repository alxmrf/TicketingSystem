package knt.org.orderService.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import knt.org.orderService.dto.input.ClientInputDto;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client extends PanacheEntity {


    @Column(unique = true)
    String cpf;
    String name;
    String email;
    Integer idade;

    public Client(ClientInputDto dto){
        this.cpf= dto.getCpf();
        this.name=dto.getName();
        this.email=dto.getEmail();
        this.idade=dto.getIdade();
    }
}
