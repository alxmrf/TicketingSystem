package knt.org.orderService.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import knt.org.orderService.dto.input.ClientInputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Client extends PanacheEntity {

    @Id
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
