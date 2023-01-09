package com.ajudante.tarefas.projetotarefa.api.controller;
import com.ajudante.tarefas.projetotarefa.domain.model.Tarefa;
import com.ajudante.tarefas.projetotarefa.domain.model.Usuario;
import com.ajudante.tarefas.projetotarefa.domain.repository.TarefaRepository;
import com.ajudante.tarefas.projetotarefa.service.CadastroTarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private CadastroTarefaService cadastroTarefaService;

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa adicionar(@RequestBody @Valid Tarefa tarefa) {

        return cadastroTarefaService.salvar(tarefa);
    }


    @DeleteMapping("/{tarefaId}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deletar(@PathVariable Long tarefaId) {
        return cadastroTarefaService.deletar(tarefaId);

    }

    @GetMapping("/{tarefaId}")
    @ResponseStatus(HttpStatus.OK)
    public Tarefa buscar(@PathVariable Long tarefaId) {
        return cadastroTarefaService.buscarTarefasPorId(tarefaId);
    }

    @PutMapping("/{tarefaId}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean atualizar(@PathVariable Long tarefaId,  @RequestBody Tarefa tarefa) {

        return cadastroTarefaService.atualizar(tarefaId, tarefa);
    }


}
