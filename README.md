
O README deve ser escrito em português (Brasil), utilizando Markdown, com aparência moderna, organizada e profissional.

Não utilize emojis.

O projeto possui as seguintes características:

Nome do projeto:
Employee Management API

Descrição:
API REST para gerenciamento de funcionários desenvolvida em Java utilizando Spring Boot como solução para um desafio técnico.

O objetivo foi demonstrar conhecimento em arquitetura de software, boas práticas de programação, orientação a objetos e desenvolvimento de APIs REST.

=====================================================

TECNOLOGIAS

- Java 21
- Spring Boot
- Spring Web
- Bean Validation
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

=====================================================

ARQUITETURA

A aplicação foi organizada seguindo princípios inspirados em:

- Clean Architecture
- Domain-Driven Design (DDD)
- SOLID
- Clean Code

Estrutura:

src/main/java
└── br.com.leo.apigestaofuncionarios
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

Explique rapidamente a responsabilidade de cada camada.

=====================================================

FUNCIONALIDADES

A API permite:

- Cadastrar funcionário
- Buscar funcionário por ID
- Listar todos os funcionários
- Atualizar funcionário
- Excluir funcionário
- Validação dos dados recebidos
- Tratamento global de exceções
- Documentação automática da API utilizando Swagger

=====================================================

PERSISTÊNCIA

Explique que, conforme solicitado pelo desafio técnico, a aplicação NÃO utiliza banco de dados.

Toda persistência foi implementada utilizando um HashMap<Long, Funcionario>, encapsulado na camada de infraestrutura através do Repository Pattern.

=====================================================

ENDPOINTS

Criar uma tabela contendo:

POST   /funcionarios
GET    /funcionarios
GET    /funcionarios/{id}
PUT    /funcionarios/{id}
DELETE /funcionarios/{id}

Adicionar uma breve descrição para cada endpoint.

=====================================================

SWAGGER

Criar uma seção explicando como acessar a documentação.

http://localhost:8080/swagger-ui/index.html

=====================================================

COMO EXECUTAR

Adicionar instruções utilizando Maven.

git clone

cd

mvn spring-boot:run

=====================================================

PADRÕES UTILIZADOS

Criar uma seção contendo:

- SOLID
- Clean Architecture
- Domain-Driven Design (DDD)
- Repository Pattern
- DTO Pattern
- Mapper Pattern
- Dependency Injection
- Global Exception Handler
- Bean Validation

Explicar rapidamente cada um.

=====================================================

DECISÕES DE ARQUITETURA

Criar uma seção explicando as principais decisões adotadas durante o desenvolvimento, como:

- Separação de responsabilidades
- Baixo acoplamento
- Alta coesão
- Uso de interfaces
- Inversão de dependência
- Organização em camadas
- Facilidade para substituir o mecanismo de persistência futuramente

=====================================================

MELHORIAS FUTURAS

Criar uma lista contendo:

- Persistência com PostgreSQL
- Spring Data JPA
- Docker
- Docker Compose
- Testes unitários com JUnit 5
- Mockito
- Testes de integração
- Spring Security
- JWT
- Paginação
- Filtros
- Ordenação
- Logs
- CI/CD com GitHub Actions

=====================================================

QUALIDADE

O README deve parecer um projeto profissional de portfólio de um desenvolvedor Java Backend.

Utilize títulos, subtítulos, tabelas e blocos de código sempre que fizer sentido.

Não deixe nenhuma seção superficial.

Explique cada tecnologia e cada decisão arquitetural de forma objetiva.

O resultado deve ser digno de um projeto que será apresentado em processos seletivos para vagas de Desenvolvedor Java Backend Júnior.
