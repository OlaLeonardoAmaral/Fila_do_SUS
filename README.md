# Fila do SUS

---
<div align="center">
  <img align="center" alt="Leo-HTML" height="50" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angular/angular-original.svg">
  
  <img align="center" alt="Leo-HTML" height="50" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg">
  
  <img align="center" alt="Leo-HTML" height="50" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg">
</div>

---

# Back-End

### Requisitos
- <a href="https://efficient-sloth-d85.notion.site/Instalando-Java-17-a6636205fb13442d86998dda72710fdc">Java 17</a>
- <a href="https://efficient-sloth-d85.notion.site/Maven-4b297322549040f1ad2bf61d6080dd0a">Maven</a>

### Configurações

Arquivo application.properties exemplo:

<img width="280" alt="image" src="https://github.com/OlaLeonardoAmaral/Fila_do_SUS/assets/86934921/96a8df1b-0a90-452a-a767-bd59fc891715">

```java
spring.datasource.url=jdbc:mysql://localhost:3306/DATA_BASE_NAME
spring.datasource.username=DB_USERNAME
spring.datasource.password=DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

# Funcionalidades

Adicionar um paciente
### POST `/paciente/adicionar`

#### Request body

```json
{
  "nome": "Leonardo",
  "idade": 22,
  "cpf": "123.123.123.12"
}
```

#### Response body

```json
{
  "id": 1,
  "nome": "Leonardo",
  "idade": 22,
  "cpf": "123.123.123.12",
  "status": "EM ESPERA"
}
```


