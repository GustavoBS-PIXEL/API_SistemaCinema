Olá, API_SistemaCinema é uma avaliação da materia de Sistemas Distribuidos voltado para a criação de uma API fulcional com o diversos temas, no qual o seleciona aqui foi o Cinema.
A API é voltada do gerencamento de um cinema, contando con funcionalidades voltadas para cadastro e controle de clientes, filmes, salas, ingressos e sessões.

Como Utilizar:
Para por em uso é necesario que voce faça o dowload do repositorio e tenha o pgAdmin 4(postgresql) e nele crie um banco de dados com o nome "cinema".
Dentro do projeto API_SistemaCinema localize o arquivo "application.properties" e fala as seguintes alteraçoes:
Nas linhas 4 e 5 tera o seguinte codigo conte:
"spring.datasource.username=postgres"
"spring.datasource.password=987456"
Nele é necesario que voce substitua "postgres" pelo nome do usuario que voce dadastrou no pgAdmin 4 e o "987456" pela senha do usuario anterior.
