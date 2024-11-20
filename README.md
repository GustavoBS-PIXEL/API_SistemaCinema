Olá!

A API_SistemaCinema é uma avaliação da matéria de Sistemas Distribuídos, focada na criação de uma API funcional que aborda diversos temas, sendo o Cinema o tema selecionado. Esta API é projetada para gerenciar um cinema, oferecendo funcionalidades externas para cadastro e controle de clientes, filmes, salas, entradas e sessões.

Para utilizá-la, siga os passos abaixo:

1. Faça o download do repositório.
2. Instale o pgAdmin 4 (PostgreSQL).
3. Crie um banco de dados com o nome "cinema" no pgAdmin 4.

Dentro do projeto API_SistemaCinema:

1. Localize o arquivo "application.properties".
2. Altere as linhas 4 e 5 conforme abaixo:

spring.datasource.username=postgres
spring.datasource.password=987456

Substitua:

- "postgres" pelo nome do usuário cadastrado no pgAdmin 4.
- "987456" pela senha correspondente.

Com essas configurações, você estará pronto para utilizar a API_SistemaCinema.

Para testar voce pode estar utilizando Swagger e o Postman.

A ordem para inserir os dados nas tabelas são respectivamente Cliente, Filme, SalaCinema, Sessão e Ingresso.

Abaixo scripts que podem ser usados para inserir dados nas tabelas do banco de dados pelo Postman e seus endpoints:

- Tabela Cliente: http://localhost:8080/api/siscinema/cliente
{
"id": 123,
"nome": "João Silva",
"cpf": "123.456.789-10",
"email": "joao.silva@example.com",
"telefone": "(11) 9 1234-5678",
"data_nas": "1990-02-12"
}

- Tabela Filme: http://localhost:8080/api/siscinema/filme
{
    "id": 123,
    "nome": "O Senhor dos Anéis",
    "descricao": "Uma aventura épica de fantasia",
    "genero": "Fantasia",
    "classificacaoetaria": "16 anos",
    "nota": 9.5,
    "datalancamento": "2024-03-14"
}

- Tabela SalaCinema: http://localhost:8080/api/siscinema/salacinema
{
"id": 123,
"nome": "Sala 1",
"tamanho": "20m²",
"num_cadeiras": "50"
}

- Tabela Sessao: http://localhost:8080/api/siscinema/sessao
{
    "id": 123,
    "filme": {"id": 1},
    "salaCinema": {"id": 1},
    "data": "2024-03-15",
    "hora": "19:00:00"
}

- Tabela Ingresso: http://localhost:8080/api/siscinema/ingresso
{
"id": 123,
"sessao": {"id": 1},
"cliente": {"id": 1},
"num_cadeira": "A10",
"data_compra": "2024-03-10"
}
