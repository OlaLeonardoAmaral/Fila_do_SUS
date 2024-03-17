## Fila do SUS
Seja bem-vindo ao projeto "Fila do SUS"! Sabemos o quão desafiador e burocrático é para um paciente, acompanhar seu histórico em uma fila de um hospital público. Por isso, desenvolvemos o site Fila do SUS, uma solução ágil e eficiente para facilitar a vida dos pacientes.

## Vamos começar
Antes de começar, é necessário ter instalado em sua máquina o [Java 17](https://efficient-sloth-d85.notion.site/Instalando-Java-17-a6636205fb13442d86998dda72710fdc), [Maven](https://efficient-sloth-d85.notion.site/Maven-4b297322549040f1ad2bf61d6080dd0a), [MySQL](https://dev.mysql.com/downloads/mysql/) (preferencialmente na versão [8.0.36]() ou anterior) e a sua IDE preferida. Além disso, você também pode começar simplesmente navegando pelo repositório e encontrando o que é de seu interesse. Após concluir essas instalações, você pode clonar o projeto usando o comando git clone, **configurar o application.properties** como mostra logo abaixo com as configurações do seu banco de dados e começar a trabalhar no projeto. Sinta-se à vontade para fazer alterações e nos enviar pull requests com suas modificações.

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

## Endpoints

O aplicativo define os seguintes endpoints:

### Pacientes

| Método | Url | Descrição | Exemplo de corpo de solicitação válido | 
| ------ | --- | --------- | -------------------------------------- |
| POST   | /paciente/adicionar   | Criar paciente                   | |
| GET    | /paciente/nome/{nome} | Buscar paciente por nome         | |
| GET    | /paciente/cpf/{cpf}   | Buscar paciente por CPF          | |
| GET    | /paciente/            | Retorna uma lista de pacientes   | |
| PUT    | /pacicente/{id}       | Atualizar o cadastro do paciente | |
| DELETE | /pacicente/{id}       | Delete paciente                  | |


## Banco de dados

``` mysql
CREATE TABLE `hospitals` (
  `hospital_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(25) DEFAULT 'EM ESPERA',
  `hospital_id` int DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `FKavr69byb4acg3j289g1oq08pk` (`hospital_id`),
  CONSTRAINT `FKavr69byb4acg3j289g1oq08pk` FOREIGN KEY (`hospital_id`) REFERENCES `hospitals` (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

<img width="499" alt="image" src="https://github.com/OlaLeonardoAmaral/Fila_do_SUS/assets/86934921/27689102-4a63-4cbc-8c93-a2abda8005c1">


