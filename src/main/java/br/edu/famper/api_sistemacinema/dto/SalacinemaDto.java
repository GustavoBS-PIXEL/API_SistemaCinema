package br.edu.famper.api_sistemacinema.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalacinemaDto {
    @Schema(description = "Nome da sala de cinema",
            example = "A-1",
            title = "nome",
            maxLength = 10)
    private String nome;

    @Schema(description = "Tamanho da sala",
            example = "150 m²",
            title = "tamanho",
            maxLength = 30)
    private String tamanho;

    @Schema(description = "Numero de cadeiras da sala",
            example = "150",
            title = "numero de cadeiras",
            maxLength = 10)
    private String num_cadeiras;
}