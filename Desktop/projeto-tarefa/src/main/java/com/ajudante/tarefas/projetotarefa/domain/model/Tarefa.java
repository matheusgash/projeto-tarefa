package com.ajudante.tarefas.projetotarefa.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarefa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_da_tarefa")
    private String nomeDaTarefa;

    private String descricao;

    @Column(name = "status_tarefa")
    private Boolean statusTarefa = Boolean.FALSE;

    @ManyToOne
    private Usuario usuario;
}

