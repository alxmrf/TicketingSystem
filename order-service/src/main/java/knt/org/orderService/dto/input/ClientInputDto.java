package knt.org.orderService.dto.input;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ClientInputDto {
    String cpf;
    String name;
    String email;
    Integer idade;
}
