package com.ajudante.tarefas.projetotarefa.service;

import com.ajudante.tarefas.projetotarefa.domain.model.Usuario;
import com.ajudante.tarefas.projetotarefa.domain.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Boolean deletar(Long usuarioId) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(usuarioId);

        if (usuarioBuscado.isEmpty()) {
            return Boolean.FALSE;
        }
        usuarioRepository.deleteById(usuarioId);
        return Boolean.TRUE;
    }


    public Usuario buscarUsuarioPorId(Long usuarioId) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
        return optionalUsuario.get();
    }

    public Boolean atualizar(Long usuarioId, Usuario usuario) {

        //busca o usuario que quero atualizar no banco de dados
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(usuarioId);

        if (usuarioBuscado.isEmpty()) {
            return Boolean.FALSE;
        }

        //pega o corpo que passei na requisição, e passa para o usuario que busquei no banco de dados
        BeanUtils.copyProperties(usuario, usuarioBuscado.get(), "id");
        usuarioRepository.save(usuarioBuscado.get());

        return Boolean.TRUE;

    }


}

