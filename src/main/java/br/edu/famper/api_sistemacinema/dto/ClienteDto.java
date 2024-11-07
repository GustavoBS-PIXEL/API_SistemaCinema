package br.edu.famper.api_sistemacinema.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
    @Schema(description = "Nome do cliente",
            example = "Gustavo",
            title = "nome",
            maxLength = 250)
    private String nome;

    @Schema(description = "CPF do cliente",
            example = "999.999.999-99",
            title = "cpf",
            maxLength = 20)
    private String cpf;

    @Schema(description = "Email do cliente",
            example = "Cliente@gmail.com",
            title = "email",
            maxLength = 100)
    private String email;

    @Schema(description = "Telefone do cliente",
            example = "(99)99912-3456",
            title = "telefone",
            maxLength = 50)
    private String telefone;

    @Schema(description = "Data de nascimento do cliente",
            example = "05/05/1999",
            title = "data de nascimento")
    private Date data_nas;
}
