# Gerenciador de Tarefas API

Uma API RESTful simples para gerenciamento de tarefas, desenvolvida como parte de uma atividade acadêmica. O projeto utiliza o ecossistema Spring para criar endpoints que permitem realizar operações de CRUD (Criar, Ler, Atualizar, Deletar) em um recurso de "Tarefa".

## ✨ Tecnologias Utilizadas

- **Java 17:** Versão da linguagem de programação.
- **Spring Boot 3:** Framework principal para a criação da aplicação.
- **Spring Web:** Módulo para a construção de APIs RESTful.
- **Spring Data JPA:** Camada de abstração para persistência de dados.
- **H2 Database:** Banco de dados relacional em memória para desenvolvimento e testes.
- **Maven:** Ferramenta de gerenciamento de dependências e build do projeto.

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 17 (ou superior)
- Maven 3.6 (ou superior)

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/gerenciador_tarefas.git](https://github.com/seu-usuario/gerenciador_tarefas.git)
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd gerenciador_tarefas
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  A API estará disponível em `http://localhost:8080`.

## Endpoints da API

A URL base para todos os endpoints é `/api/tarefas`.

| Método | URI                | Descrição                  |
| :----- | :----------------- | :------------------------- |
| `POST` | `/api/tarefas`                | Cria uma nova tarefa.       |
| `POST` | `/api/tarefas/lote`           | Cria uma lista de tarefas.  |
| `GET`  | `/api/tarefas`                | Lista todas as tarefas.     |
| `GET`  | `/api/tarefas/{id}`           | Busca uma tarefa por ID.    |
| `PUT`  | `/api/tarefas/{id}`           | Atualiza uma tarefa por ID. |
| `DELETE`| `/api/tarefas/{id}`          | Deleta uma tarefa por ID.   |

## 🧪 Como Testar

Para testar os endpoints, você pode utilizar uma ferramenta como o **Postman** ou o **Insomnia**.

- **Para criar ou atualizar uma tarefa**, envie uma requisição `POST` ou `PUT` para a URI correspondente com um corpo (body) no formato JSON, como no exemplo abaixo:


| `POST` | `http://localhost:8080/api/tarefas/lote`
```json
[
  {
    "nome": "tarefa 1",
    "descricao": "A tarefa 1",
    "dataEntrega": "2025-12-12",
    "responsavel": "admin"
  },
  {
    
    "nome": "tarefa 2",
   "descricao": "A tarefa 2",
    "dataEntrega": "2025-10-31",
    "responsavel": "admin"
  },
  {
    "nome": "tarefa 3",
    "descricao": "A tarefa 3",
    "dataEntrega": "2025-08-29",
    "responsavel": "admin"
  }
]


| `POST` | `http://localhost:8080/api/tarefas/lote`
```json
{
    "nome": "tarefa 1",
    "descricao": "A tarefa 1",
    "dataEntrega": "2025-12-12",
    "responsavel": "admin"
},
