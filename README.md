## Fila do SUS
Seja bem-vindo ao projeto "Fila do SUS"! Sabemos o quão desafiador e burocrático é para um paciente, acompanhar seu histórico em uma fila de um hospital público. Por isso, desenvolvemos o site Fila do SUS, uma solução ágil e eficiente para facilitar a vida dos pacientes.

## Vamos começar
Antes de começar, é necessário ter instalado em sua máquina o [Java 17](), [Maven](), [MySQL]() (preferencialmente na versão [8.0.36]()) e a sua IDE preferida. Além disso, você também pode começar simplesmente navegando pelo repositório e encontrando o que é de seu interesse. Após concluir essas instalações, você pode clonar o projeto usando o comando git clone, **configurar o application.properties** como mostra logo abaixo com as configurações do seu banco de dados e começar a trabalhar no projeto. Sinta-se à vontade para fazer alterações e nos enviar pull requests com suas modificações.

## Configurações
```
├── src
|  ├── main
|  |   └── resources
│  │       └── application.properties  <-
|  └── test
└── target

Exemplo

spring.datasource.url=jdbc:mysql://localhost:3306/DATA_BASE_NAME
spring.datasource.username=DB_USERNAME
spring.datasource.password=DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```