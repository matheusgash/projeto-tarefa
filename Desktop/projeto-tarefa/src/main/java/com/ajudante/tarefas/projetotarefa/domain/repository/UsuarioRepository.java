package com.ajudante.tarefas.projetotarefa.domain.repository;

import com.ajudante.tarefas.projetotarefa.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
