package br.edu.famper.api_sistemacinema.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmeDto {
    @Schema(description = "Nome do filme",
            example = "Homem de Ferro",
            title = "nome",
            maxLength = 100)
    private String nome;

    @Schema(description = "Descrição do filme",
            example = "O filme conta a historia de vida de Gustavo",
            title = "descricao",
            maxLength = 300)
    private String descricao;

    @Schema(description = "Genero do filme",
            example = "Romance",
            title = "genero",
            maxLength = 100)
    private String genero;

    @Schema(description = "Classificação etaria do filme",
            example = "Livre",
            title = "classificação etaria",
            maxLength = 50)
    private String classificacaoetaria;

    @Schema(description = "Nota do filme",
            example = "7.5",
            title = "data de nascimento")
    private Double nota;

    @Schema(description = "Data de lançamento do filme",
            example = "1999-09-09",
            title = "data de lançamento")
    private Date data_lanc;
}