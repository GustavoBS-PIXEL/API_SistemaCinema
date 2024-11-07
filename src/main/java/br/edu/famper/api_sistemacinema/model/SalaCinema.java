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

    @Column(name = "nome", length = 10)
    private String nome;

    @Column(name = "tamanho", length = 30)
    private String tamanho;

    @Column(name = "num_cadeiras", length = 10)
    private String num_cadeiras;

    @OneToMany(mappedBy = "sala", targetEntity = Sessao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Sessao> sessoes;
}
