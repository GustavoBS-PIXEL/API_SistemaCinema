package br.edu.famper.api_sistemacinema.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "tbl_ingresso")
@Data

public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ingresso_id")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "num_cadeira", length = 20)
    private String num_cadeira;

    @Column(name = "data_compra")
    private Date data_compra;

}
