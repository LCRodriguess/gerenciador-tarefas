// --------------------------------------------------------------
// Projeto: Gerenciador de Tarefas
// Autor: Leonardo Rodrigues
// RU: 4745830
// Descrição: Aplicação Spring Boot para gerenciar tarefas com operações CRUD e de acordo com o padrão REST.
// --------------------------------------------------------------

package br.com.uninter.gerenciador_tarefas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    private String nome;
    private String ru;
    private LocalDate dataEntrega;
    private String responsavel;

    // Getters e Setters para as propriedades
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}