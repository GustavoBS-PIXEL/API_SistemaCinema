package br.edu.famper.api_sistemacinema.dto;

import br.edu.famper.api_sistemacinema.model.Filme;
import br.edu.famper.api_sistemacinema.model.SalaCinema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessaoDto {
    @Schema(description = "Identificação do filme",
            example = "1",
            title = "filme")
    private Filme filme;

    @Schema(description = "Identificação da sala",
            example = "2",
            title = "cpf")
    private SalaCinema salaCinema;

    @Schema(description = "Data da sessão",
            example = "2011-11-11",
            title = "data")
    private Date data;

    @Schema(description = "Hora da sessão",
            example = "13:30:00",
            title = "hora")
    private Time hora;
}
