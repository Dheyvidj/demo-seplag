# Demo Seplag API

Este projeto é uma API RESTful desenvolvida em Java 17 com Spring Boot, utilizando PostgreSQL como banco de dados e
MinIO para armazenamento de imagens. A API oferece endpoints para gerenciamento de entidades como Servidor Efetivo,
Servidor Temporário, Unidade, Lotação, Pessoa e Fotos. A autenticação é realizada via JWT (Bearer Token).

A documentação interativa da API é gerada automaticamente com Swagger e uma collection do Postman está disponível no
repositório para facilitar os testes.

---

## Recursos

- **Autenticação JWT**: Endpoints para login e refresh com geração de token.
- **CRUD Completo**: Endpoints para criação, consulta, atualização e exclusão das entidades (Servidor Efetivo, Servidor
  Temporário, Unidade, Lotação, Pessoa e Fotos).
- **Upload de Fotos**: Integração com MinIO para upload de imagens e geração de URL temporária.
- **Documentação Interativa**: Swagger UI disponível para visualização e testes dos endpoints.
- **Collection Postman**: Collection completa dos endpoints disponível no repositório.
- **Docker Compose**: Orquestração dos containers da aplicação, PostgreSQL e MinIO.

---

## Pré-requisitos

- Java 17
- Maven
- Docker e Docker Compose

---

## Instalação e Execução

### Executando com Docker Compose

O repositório inclui um arquivo docker-compose.yml que orquestra os containers para a aplicação, PostgreSQL e MinIO.

1. **Certifique-se de que o Docker e o Docker Compose estejam instalados.**

2. **Inicie os containers:**

   ```bash
    docker-compose up --build
    ```

3. **Acesse a API:**
   A aplicação ficará disponível em http://localhost:8080.

### Documentação da API

A documentação interativa está disponível através do Swagger UI. Após iniciar a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html

Nesta interface, você poderá visualizar e testar todos os endpoints da API.

### Collection Postman

Uma collection do Postman com todos os endpoints da API está incluída no repositório com o nome:
``Demo Seplag API.postman_collection.json``.

Para utilizá-la:

1. Importe a collection no Postman.

2. Configure a variável base_url (ex.: http://localhost:8080).

3. Utilize os endpoints.

### Autenticação e Segurança

- Bearer Token: Todos os endpoints, exceto os de autenticação e Swagger, exigem um token JWT no header Authorization no
  formato:

css
Copiar

````
Authorization: Bearer {seu_token}
````

- Utilize o endpoint /api/auth/login para obter o token e o /api/auth/refresh para renová-lo.

- A configuração do Swagger está preparada para reconhecer a autenticação Bearer.

- O banco é criado com um usuário padrão para teste:
    - ```    { "username": "admin", "password": "admin"}     ```