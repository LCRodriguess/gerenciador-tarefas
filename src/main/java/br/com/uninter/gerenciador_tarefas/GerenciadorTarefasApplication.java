// --------------------------------------------------------------
// Projeto: Gerenciador de Tarefas
// Autor: Leonardo Rodrigues
// RU: 4745830
// Descrição: Aplicação Spring Boot para gerenciar tarefas com operações CRUD e de acordo com o padrão REST.
// --------------------------------------------------------------

package br.com.uninter.gerenciador_tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorTarefasApplication.class, args);
	}

}
