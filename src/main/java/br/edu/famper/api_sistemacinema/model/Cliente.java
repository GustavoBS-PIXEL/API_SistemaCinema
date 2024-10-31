package br.edu.famper.api_sistemacinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_cliente")
@Data

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Cliente_id")
    private Long codigo;

    @Column(name = "nome", length = 250)
    private String nome;

    @Column(name = "cpf", length = 20)
    private String cpf;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefone", length = 50)
    private String telefone;

    @Column(name = "data_nas")
    private Date nota;

    @OneToMany(mappedBy = "cliente", targetEntity = Ingresso.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Ingresso> ingressos;

}
