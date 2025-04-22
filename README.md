
# Fila do SUS

**Seja bem-vindo ao projeto "Fila do SUS"!** Este projeto foi desenvolvido com o intuito de melhorar a experiência dos pacientes que enfrentam a burocracia e os desafios de acompanhar seu histórico em filas de hospitais públicos. Nossa solução ágil e eficiente visa facilitar a vida dos pacientes, proporcionando um sistema que torna o acompanhamento de suas informações muito mais simples e acessível.



## 🚀 Vamos Começar

Antes de iniciar, você precisará instalar em sua máquina as seguintes ferramentas:

- [Java 17](https://efficient-sloth-d85.notion.site/Instalando-Java-17-a6636205fb13442d86998dda72710fdc)
- [Maven](https://efficient-sloth-d85.notion.site/Maven-4b297322549040f1ad2bf61d6080dd0a)
- [MySQL](https://dev.mysql.com/downloads/mysql/) (preferencialmente na versão [8.0.36](https://dev.mysql.com/downloads/mysql/))

**Dica:** Você também pode explorar o repositório para descobrir funcionalidades interessantes. 

Após a instalação, clone o projeto usando o comando:

```bash
git clone https://github.com/OlaLeonardoAmaral/Fila_do_SUS.git
```

Em seguida, configure o arquivo `application.properties` conforme o exemplo abaixo, utilizando as informações do seu banco de dados:

### Configurações

```plaintext
├── src
|  ├── main
|  |   └── resources
│  │       └── application.properties  <-
|  └── test
└── target

# Exemplo de configuração
spring.datasource.url=jdbc:mysql://localhost:3306/DATA_BASE_NAME
spring.datasource.username=DB_USERNAME
spring.datasource.password=DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

---

## 📡 Endpoints

O aplicativo possui os seguintes endpoints para gerenciar pacientes:

| Método | Url                        | Descrição                           | Exemplo de corpo de solicitação válido |
| ------ | -------------------------- | ----------------------------------- | -------------------------------------- |
| POST   | /paciente/adicionar        | Criar novo paciente                 |                                        |
| GET    | /paciente/nome/{nome}     | Buscar paciente por nome            |                                        |
| GET    | /paciente/cpf/{cpf}       | Buscar paciente por CPF             |                                        |
| GET    | /paciente/                | Retorna uma lista de pacientes      |                                        |
| PUT    | /paciente/{id}            | Atualizar o cadastro do paciente    |                                        |
| DELETE | /paciente/{id}            | Deletar paciente                    |                                        |

---

## 🗄 Banco de Dados

![Banco de Dados](https://github.com/OlaLeonardoAmaral/Fila_do_SUS/assets/86934921/27689102-4a63-4cbc-8c93-a2abda8005c1)

---

## 🛠 Tecnologias Utilizadas

- **Frontend:** ![Angular](https://img.shields.io/badge/Angular-3DDC84?style=for-the-badge&logo=angular&logoColor=white)
- **Backend:** ![Java 17](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) 
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
- **Banco de Dados:** ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## 🧠 Minha Experiência

Durante o desenvolvimento deste projeto, tive a oportunidade de **construir o banco de dados e desenvolver o backend**, utilizando tecnologias como **Spring Boot** e **MySQL**. Essa experiência não apenas aprimorou minhas habilidades em programação, mas também me permitiu compreender melhor a arquitetura de sistemas e a interação entre frontend e backend. A colaboração com a Giovanna, que ficou responsável pelo frontend, foi fundamental para garantir uma interface intuitiva e eficiente, tornando o projeto mais completo e funcional.

