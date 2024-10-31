package br.edu.famper.api_sistemacinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "tbl_sessao")
@Data

public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sessao_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private SalaCinema sala;

    @Column(name = "data")
    private Date data;

    @Column(name = "hora")
    private Time hora;

    @OneToMany(mappedBy = "sessao", targetEntity = Ingresso.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ingresso> ingressos;
}
