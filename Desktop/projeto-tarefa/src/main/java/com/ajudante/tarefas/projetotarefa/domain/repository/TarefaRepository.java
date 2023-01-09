package com.ajudante.tarefas.projetotarefa.domain.repository;


import com.ajudante.tarefas.projetotarefa.domain.model.Tarefa;
import com.ajudante.tarefas.projetotarefa.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
