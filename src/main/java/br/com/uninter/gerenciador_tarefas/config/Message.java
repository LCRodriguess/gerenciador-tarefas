// --------------------------------------------------------------
// Projeto: Gerenciador de Tarefas
// Autor: Leonardo Rodrigues
// RU: 4745830
// Descrição: Aplicação Spring Boot para gerenciar tarefas com operações CRUD e de acordo com o padrão REST.
// --------------------------------------------------------------

package br.com.uninter.gerenciador_tarefas.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.uninter.gerenciador_tarefas.controller.TarefaController;

@Component
public class Message implements ApplicationRunner {

    // Códigos de cores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final DataSource dataSource;
    private final TarefaController tarefaController;

    // Injeção de dependências via construtor
    public Message(DataSource dataSource, TarefaController tarefaController) {
        this.dataSource = dataSource;
        this.tarefaController = tarefaController;
    }

    // Executado após o startup da aplicação
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n--- INICIANDO VALIDAÇÃO PÓS-STARTUP ---");

        // 1. Valida a conexão com o Banco de Dados
        boolean dbOk = validarConexaoBanco();

        // 2. Valida a inicialização da API (Controller)
        boolean apiOk = validarControllerAPI();

        // 3. Imprime o banner final com o status real
        imprimirMessage(dbOk, apiOk);
    }
    
    // Valida a conexão com o Banco de Dados
    private boolean validarConexaoBanco() {
        System.out.print(">> Validando conexão com o Banco de Dados... ");
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(10)) { // Timeout de 10 segundos
                System.out.println(ANSI_GREEN + "SUCESSO!" + ANSI_RESET);
                return true;
            } else {
                System.out.println(ANSI_RED + "FALHA (Conexão inválida)!" + ANSI_RESET);
                return false;
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "FALHA!" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "   Erro: " + e.getMessage() + ANSI_RESET);
            return false;
        }
    }

    // Valida se o Controller foi corretamente injetado
    private boolean validarControllerAPI() {
        System.out.print(">> Validando inicialização da API (Controller)... ");
        if (tarefaController != null) {
            System.out.println(ANSI_GREEN + "SUCESSO!" + ANSI_RESET);
            return true;
        } else {
            System.out.println(ANSI_RED + "FALHA (Controller não foi injetado)!" + ANSI_RESET);
            return false;
        }
    }

    // Imprime a mensagem final com o status da aplicação e minha assinatura de desenvolvedor
    private void imprimirMessage(boolean dbStatus, boolean apiStatus) {
        String statusMessage = (dbStatus && apiStatus)
            ? ANSI_GREEN + "STATUS: ONLINE E PRONTA!" + ANSI_RESET
            : ANSI_RED + "STATUS: INICIALIZAÇÃO COM FALHAS!" + ANSI_RESET;

        System.out.println("\n========================================");
        System.out.println("|                                      |");
        System.out.println("|   API Gerenciador de Tarefas v1.0    |");
        System.out.println("|   Por: Leonardo Coelho Rodrigues     |");
        System.out.println("|   RU:  4745830                       |");
        System.out.println("|   " + statusMessage + "           |");
        System.out.println("========================================");

        if (dbStatus && apiStatus) {
            System.out.println("\n>> Console H2 disponível em: http://localhost:8080/h2-console");
            System.out.println(">> API pronta para receber requisições.\n");
        } else {
            System.out.println(ANSI_RED + "\n>> A aplicação iniciou, mas um ou mais componentes críticos falharam." + ANSI_RESET);
            System.out.println(ANSI_RED + ">> Verifique os logs de erro acima.\n" + ANSI_RESET);
        }
    }
}