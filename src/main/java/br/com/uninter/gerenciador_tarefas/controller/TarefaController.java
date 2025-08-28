// --------------------------------------------------------------
// Projeto: Gerenciador de Tarefas
// Autor: Leonardo Rodrigues
// RU: 4745830
// Descrição: Aplicação Spring Boot para gerenciar tarefas com operações CRUD e de acordo com o padrão REST.
// --------------------------------------------------------------

package br.com.uninter.gerenciador_tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.uninter.gerenciador_tarefas.model.Tarefa;
import br.com.uninter.gerenciador_tarefas.repository.TarefaRepository;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED) // Define o status HTTP 201 Created para respostas bem-sucedidas
    public Tarefa criar(@RequestBody Tarefa tarefa) { //
        return tarefaRepository.save(tarefa); // Salva a nova tarefa no banco de dados e retorna a tarefa salva
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // GET METHOD - Buscar uma tarefa por ID - EX: localhost:8080/api/tarefas/1  [1 é o ID]
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id) // Usa o método findById do repositório para buscar a tarefa pelo ID
                .map(ResponseEntity::ok) // Se a tarefa for encontrada, retorna 200 OK com a tarefa no corpo da resposta
                .orElse(ResponseEntity.notFound().build()); // Se não for encontrada, retorna 404 Not Found
    }

    // PUT METHOD - Atualizar os dados de uma tarefa existente - EX: localhost:8080/api/tarefas/1
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaDetalhes) {
        return tarefaRepository.findById(id)
                .map(tarefa -> { // Atualiza os campos da tarefa existente com os novos dados de cada propriedade
                    tarefa.setNome(tarefaDetalhes.getNome());
                    tarefa.setRu(tarefaDetalhes.getRu());
                    tarefa.setDataEntrega(tarefaDetalhes.getDataEntrega());
                    tarefa.setResponsavel(tarefaDetalhes.getResponsavel());
                    Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);
                    return ResponseEntity.ok(tarefaAtualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE METHOD - Deletar uma tarefa por ID - EX: localhost:8080/api/tarefas/1
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tarefaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}