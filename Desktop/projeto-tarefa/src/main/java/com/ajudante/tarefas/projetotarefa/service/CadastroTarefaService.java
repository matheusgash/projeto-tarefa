package com.ajudante.tarefas.projetotarefa.service;

import com.ajudante.tarefas.projetotarefa.domain.model.Tarefa;
import com.ajudante.tarefas.projetotarefa.domain.repository.TarefaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CadastroTarefaService {


    @Autowired
    private TarefaRepository tarefaRepository;


    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }


    public Boolean deletar(Long tarefaId) {
        Optional<Tarefa> tarefaBuscada = tarefaRepository.findById(tarefaId);

        if (tarefaBuscada.isEmpty()) {
            return Boolean.FALSE;
        }
        tarefaRepository.deleteById(tarefaId);
        return Boolean.TRUE;
    }

    public Tarefa buscarTarefasPorId(Long tarefaId) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefaId);
        return optionalTarefa.get();
    }


    public Boolean atualizar(Long tarefaId, Tarefa tarefa) {

        //busca o usuario que quero atualizar no banco de dados
        Optional<Tarefa> tarefaBuscada = tarefaRepository.findById(tarefaId);

        if (tarefaBuscada.isEmpty()) {
            return Boolean.FALSE;
        }

        //pega o corpo que passei na requisição, e passa para o usuario que busquei no banco de dados
        BeanUtils.copyProperties(tarefa, tarefaBuscada.get(), "id", "usuario");
        tarefaRepository.save(tarefaBuscada.get());

        return Boolean.TRUE;

    }
}
