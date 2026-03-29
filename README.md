# API de Usuários - Spring Boot
API REST desenvolvida com Spring Boot para gerenciamento de usuários.
O projeto foi criado com o objetivo de praticar conceitos fundamentais de backend, como arquitetura em camadas, validação de dados, tratamento de exceções e boas práticas de desenvolvimento.

# Objetivos
 - Aplicar arquitetura em camadas (Controller, Service, Model)
 - Utilizar DTOs para entrada e saída de dados
 - Implementar validação de payload
 - Tratar exceções de forma global

# Tecnologias utilizadas
- Java 17+
- Spring Boot
- Maven
- Jakarta Validation
- Postman
- 


# Estrutura do projeto
src/main/java
├── controller
├── service
├── model
├── dto
└── exceptions

🔌 Endpoints da API
➕ Criar usuário

POST /users

GET /users

GET /users/{id}

PUT /users/{id}

DELETE /users/{id}

# Exemplo de requisição

Criar usuário
<img width="1075" height="773" alt="image" src="https://github.com/user-attachments/assets/67fcdf74-1757-4c94-af0c-8677760743cb" />

# Tratamento de erros
A API possui tratamento global para:

- Dados inválidos (400 Bad Request)
- Usuário não encontrado (404 Not Found)
- Erros de tipo (ex: UUID inválido)

Exemplo de resposta:

{
  "error": "Usuário não encontrado"
}

# Validação de dados

 - Nome obrigatório
 - Email obrigatório
 - Senha obrigatória
 - Idade mínima definida

 # Segurança

A senha não é retornada na resposta da API.
(Obs: Em um ambiente real, seria aplicado hash de senha.)

# Armazenamento

Os dados são armazenados em memória utilizando uma lista.
Não há integração com banco de dados neste projeto.

# Decisões técnicas

 - Uso de UUID para garantir identificadores únicos
 - Separação de camadas para organização e manutenção
 - DTOs para evitar exposição direta da entidade
 - Service centralizando regras de negócio
 - Exception Handler para padronizar respostas de erro

# Possíveis melhorias

 - Integração com banco de dados (JPA / Hibernate)
 - Implementação de autenticação (Spring Security + JWT)
 - Criptografia de senha
 - Documentação com Swagger
 - Testes automatizados

 # Como executar o projeto
 ### Clone o repositório:
git clone https://github.com/Vitorreiis/apiusers.git
 ### Acesse o projeto:
cd apiusers
 ### Execute a aplicação:
./mvnw spring-boot:run
 ### A API estará disponível em:
http://localhost:8080

# Licença

Este projeto é apenas para fins educacionais.

# Autor

Vitor Reis
