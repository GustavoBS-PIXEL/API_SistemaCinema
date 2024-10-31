package br.edu.famper.api_sistemacinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_filme")
@Data

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "filme_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "genero", length = 100)
    private String genero;

    @Column(name = "classif_etaria", length = 50)
    private String classificacaoetaria;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "data_lanc")
    private Date datalancamento;

    @OneToMany(mappedBy = "filme", targetEntity = Sessao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Sessao> sessoes;
}
