package br.edu.famper.api_sistemacinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "tbl_salacinema")
@Data
public class SalaCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sala_id")
    private Long sala;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "tamanho", length = 300)
    private String descricao;

    @Column(name = "num_cadeiras", length = 100)
    private String genero;

    @OneToMany(mappedBy = "sala", targetEntity = Sessao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Sessao> sessoes;
}
