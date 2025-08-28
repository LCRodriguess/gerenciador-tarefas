// --------------------------------------------------------------
// Projeto: Gerenciador de Tarefas
// Autor: Leonardo Rodrigues
// RU: 4745830
// Descrição: Aplicação Spring Boot para gerenciar tarefas com operações CRUD e de acordo com o padrão REST.
// --------------------------------------------------------------

package br.com.uninter.gerenciador_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uninter.gerenciador_tarefas.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}