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

		// Mensagens de orientação para o usuário ao iniciar a aplicação
		System.out.println("Aplicação Gerenciador de Tarefas iniciada com sucesso!");
		System.out.println("Acesse a API REST em: http://localhost:8080/tasks");
		System.out.println("Use ferramentas como Postman ou curl para interagir com a API.");
	}

}
