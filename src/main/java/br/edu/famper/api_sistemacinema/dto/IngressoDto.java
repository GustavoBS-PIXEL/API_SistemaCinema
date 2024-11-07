package br.edu.famper.api_sistemacinema.dto;

import br.edu.famper.api_sistemacinema.model.Cliente;
import br.edu.famper.api_sistemacinema.model.Sessao;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngressoDto {
    @Schema(description = "Indentificação da Sessão",
            example = "1",
            title = "Sessao")
    private Sessao sessao;

    @Schema(description = "Indentificação do cliente",
            example = "1",
            title = "cliente")
    private Cliente cliente;

    @Schema(description = "Numero da cadeira",
            example = "10",
            title = "num cadeira",
            maxLength = 50)
    private String num_cadeira;

    @Schema(description = "Data de compra do ingresso",
            example = "12/12/2012",
            title = "data de compra")
    private Date data_compra;
}
