# API de Controle de Contatos e Pessoas

Esta aplicação API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos, onde cada Pessoa pode ter vários Contatos. O principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas na estrutura de Pessoas e Contatos.

## Funcionalidades

### Contatos

- **Salvar Contato**
  - **Endpoint**: `POST /api/contatos`
  - **Descrição**: Cria um novo registro de contato associado a uma pessoa existente.
  - **Corpo da Requisição**: JSON contendo tipo de contato e ID da pessoa.
  - **Resposta**: Retorna o contato criado com status HTTP 201 Created.

- **Listar Todos os Contatos**
  - **Endpoint**: `GET /api/contatos`
  - **Descrição**: Retorna todos os contatos cadastrados.
  - **Resposta**: Retorna uma lista de contatos com status HTTP 200 OK, ou 404 Not Found se nenhum contato existir.

- **Buscar Contato por ID**
  - **Endpoint**: `GET /api/contatos/{id}`
  - **Descrição**: Retorna um contato específico pelo seu ID.
  - **Parâmetro**: ID do contato a ser buscado.
  - **Resposta**: Retorna o contato encontrado com status HTTP 200 OK, ou 404 Not Found se o contato não existir.

- **Listar Contatos de uma Pessoa**
  - **Endpoint**: `GET /api/contatos/pessoa/{idPessoa}`
  - **Descrição**: Retorna todos os contatos associados a uma pessoa específica pelo ID da pessoa.
  - **Parâmetro**: ID da pessoa cujos contatos serão listados.
  - **Resposta**: Retorna uma lista de contatos da pessoa com status HTTP 200 OK, ou 404 Not Found se a pessoa não existir ou não tiver contatos.

- **Atualizar Contato**
  - **Endpoint**: `PUT /api/contatos/{id}`
  - **Descrição**: Atualiza um contato existente pelo seu ID.
  - **Parâmetro**: ID do contato a ser atualizado.
  - **Corpo da Requisição**: JSON contendo os novos dados do contato.
  - **Resposta**: Retorna o contato atualizado com status HTTP 200 OK, ou 404 Not Found se o contato não existir.

- **Excluir Contato**
  - **Endpoint**: `DELETE /api/contatos/{id}`
  - **Descrição**: Exclui um contato existente pelo seu ID.
  - **Parâmetro**: ID do contato a ser excluído.
  - **Resposta**: Retorna status HTTP 200 OK se o contato foi excluído com sucesso, ou 404 Not Found se o contato não existir.

### Pessoas

- **Salvar Pessoa**
  - **Endpoint**: `POST /api/pessoas`
  - **Descrição**: Cria um novo registro de pessoa.
  - **Corpo da Requisição**: JSON contendo os dados da pessoa (nome, endereço, etc.).
  - **Resposta**: Retorna a pessoa criada com status HTTP 201 Created.

- **Listar Todas as Pessoas**
  - **Endpoint**: `GET /api/pessoas`
  - **Descrição**: Retorna todas as pessoas cadastradas.
  - **Resposta**: Retorna uma lista de pessoas com status HTTP 200 OK, ou 404 Not Found se nenhuma pessoa existir.

- **Buscar Pessoa por ID**
  - **Endpoint**: `GET /api/pessoas/{id}`
  - **Descrição**: Retorna uma pessoa específica pelo seu ID.
  - **Parâmetro**: ID da pessoa a ser buscada.
  - **Resposta**: Retorna a pessoa encontrada com status HTTP 200 OK, ou 404 Not Found se a pessoa não existir.

- **Atualizar Pessoa**
  - **Endpoint**: `PUT /api/pessoas/{id}`
  - **Descrição**: Atualiza uma pessoa existente pelo seu ID.
  - **Parâmetro**: ID da pessoa a ser atualizada.
  - **Corpo da Requisição**: JSON contendo os novos dados da pessoa.
  - **Resposta**: Retorna a pessoa atualizada com status HTTP 200 OK, ou 404 Not Found se a pessoa não existir.

- **Excluir Pessoa**
  - **Endpoint**: `DELETE /api/pessoas/{id}`
  - **Descrição**: Exclui uma pessoa existente pelo seu ID.
  - **Parâmetro**: ID da pessoa a ser excluída.
  - **Resposta**: Retorna status HTTP 200 OK se a pessoa foi excluída com sucesso, ou 404 Not Found se a pessoa não existir.

## Como Utilizar

Para utilizar esta API, siga os passos abaixo:

1. **Configuração do Ambiente**:
   - Certifique-se de ter o ambiente de desenvolvimento configurado com JDK, Spring Boot e um banco de dados compatível.

2. **Configuração do Banco de Dados**:
   - Configure as propriedades de conexão com o banco de dados no arquivo `application.properties` ou `application.yml` conforme necessário.

3. **Execução da Aplicação**:
   - Execute a aplicação Spring Boot. A API estará disponível em `http://localhost:8080`.

4. **Teste das Funcionalidades**:
   - Utilize ferramentas como Postman ou curl para enviar requisições HTTP para os endpoints listados acima.

5. **Documentação da API**:
   - Acesse a documentação da API gerada automaticamente pelo Swagger.

## Contribuições e Suporte

Contribuições são bem-vindas! Sinta-se à vontade para reportar problemas, enviar solicitações de melhorias ou contribuir diretamente para o projeto.

---

Certifique-se de personalizar este README com base nas especificidades do seu projeto e suas necessidades.


