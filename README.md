# 🚀 Employee Management API

API REST desenvolvida com **Java 21** e **Spring Boot** para gerenciamento de funcionários. Este projeto foi criado como solução para um desafio técnico, com foco na aplicação de boas práticas de desenvolvimento, arquitetura em camadas, organização do código e princípios de engenharia de software.

A aplicação permite realizar operações completas de **CRUD (Create, Read, Update e Delete)** de funcionários, além de contar com validação de dados, tratamento global de exceções e documentação automática da API utilizando Swagger/OpenAPI.

---

## 📋 Funcionalidades

- ✅ Cadastrar funcionários
- 🔍 Buscar funcionário por ID
- 📄 Listar todos os funcionários
- ✏️ Atualizar dados de um funcionário
- 🗑️ Remover funcionários
- ✔️ Validação dos dados de entrada
- ⚠️ Tratamento global de exceções
- 📚 Documentação automática com Swagger/OpenAPI

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Bean Validation
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

---

## 🏛️ Arquitetura

O projeto foi estruturado seguindo princípios inspirados em:

- Clean Architecture
- Domain-Driven Design (DDD)
- SOLID
- Clean Code

A arquitetura foi organizada para manter baixo acoplamento, alta coesão e separação de responsabilidades, facilitando manutenção, evolução e reutilização do código.

### Estrutura do Projeto

```text
src/main/java
└── br/com/leo/apigestaofuncionarios
    └── funcionario
        ├── application
        │   ├── api
        │   ├── repository
        │   └── service
        ├── config
        ├── domain
        ├── exception
        ├── infra
        ├── mapper
        └── validator
```

### Responsabilidade das Camadas

| Camada | Responsabilidade |
|---------|------------------|
| **application/api** | Controllers, DTOs de Request/Response e contratos da API |
| **application/service** | Regras de negócio da aplicação |
| **application/repository** | Interface do repositório |
| **domain** | Entidade de domínio (`Funcionario`) |
| **infra** | Implementação da persistência utilizando `HashMap` |
| **mapper** | Conversão entre Entidades e DTOs |
| **validator** | Validação das regras de entrada |
| **exception** | Exceções customizadas e tratamento global |
| **config** | Configurações da aplicação |

---

## 📦 Persistência

Conforme especificado no desafio técnico, **não foi utilizado banco de dados**.

Os dados são armazenados em memória utilizando um:

```java
Map<Long, Funcionario>
```

A persistência foi encapsulada por meio do **Repository Pattern**, permitindo que, futuramente, seja possível substituir a implementação por um banco de dados relacional sem impactar as regras de negócio.

---

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| **POST** | `/funcionarios` | Cadastra um novo funcionário |
| **GET** | `/funcionarios` | Lista todos os funcionários |
| **GET** | `/funcionarios/{id}` | Busca um funcionário pelo ID |
| **PUT** | `/funcionarios/{id}` | Atualiza um funcionário existente |
| **DELETE** | `/funcionarios/{id}` | Remove um funcionário |

---

## 📄 Documentação da API

A documentação da API é gerada automaticamente pelo **SpringDoc OpenAPI (Swagger)**.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

*(dependendo da configuração do SpringDoc).*

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/LeoAugustoDev/employee-management-api.git
```

### 2. Acesse a pasta do projeto

```bash
cd employee-management-api
```

### 3. Execute a aplicação

Linux / macOS

```bash
./mvnw spring-boot:run
```

Windows

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## 📌 Conceitos Aplicados

- REST API
- Clean Architecture
- Domain-Driven Design (DDD)
- SOLID
- Clean Code
- Repository Pattern
- DTO Pattern
- Mapper Pattern
- Dependency Injection
- Bean Validation
- Global Exception Handling
- OpenAPI
- Swagger

---

## 🔮 Melhorias Futuras

- Persistência utilizando PostgreSQL
- Spring Data JPA
- Docker
- Docker Compose
- Testes Unitários (JUnit 5 + Mockito)
- Testes de Integração
- Spring Security
- Autenticação com JWT
- Paginação
- Filtros de pesquisa
- Logs estruturados com SLF4J
- CI/CD com GitHub Actions

---

## 👨‍💻 Autor

**Leonardo Augusto Lima Alves**

🔗 GitHub  
https://github.com/LeoAugustoDev

💼 LinkedIn  
https://www.linkedin.com/in/leonardo-augusto-93346a3b8/

---

## ⭐ Considerações Finais

Este projeto foi desenvolvido como solução para um desafio técnico, com o objetivo de demonstrar conhecimentos em **Java**, **Spring Boot**, **desenvolvimento de APIs REST**, **arquitetura em camadas**, **Clean Architecture**, **DDD**, **SOLID** e **boas práticas de desenvolvimento Backend**.

Apesar de utilizar uma persistência em memória com `HashMap`, conforme exigido pelo desafio, a aplicação foi estruturada de forma desacoplada e preparada para futuras evoluções, permitindo a substituição da camada de persistência por um banco de dados relacional com impacto mínimo nas demais camadas da aplicação.
