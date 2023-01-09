package com.ajudante.tarefas.projetotarefa.api.controller;

import com.ajudante.tarefas.projetotarefa.domain.model.Usuario;
import com.ajudante.tarefas.projetotarefa.domain.repository.UsuarioRepository;
import com.ajudante.tarefas.projetotarefa.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody @Valid Usuario usuario) {
        return cadastroUsuarioService.salvar(usuario);
    }


    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deletar(@PathVariable Long usuarioId) {
        return cadastroUsuarioService.deletar(usuarioId);

    }


    @GetMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscar(@PathVariable Long usuarioId) {
        return cadastroUsuarioService.buscarUsuarioPorId(usuarioId);
    }

    @PutMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean atualizar(@PathVariable Long usuarioId,  @RequestBody Usuario usuario) {

        return cadastroUsuarioService.atualizar(usuarioId, usuario);
    }



}
