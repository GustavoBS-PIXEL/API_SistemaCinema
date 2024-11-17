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
