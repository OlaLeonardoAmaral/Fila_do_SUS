CREATE TABLE hospitals (
  hospital_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  cep varchar(255) DEFAULT NULL,
  neighborhood varchar(255) DEFAULT NULL,
  number varchar(255) DEFAULT NULL,
  PRIMARY KEY (hospital_id)
);

CREATE TABLE patients (
  patient_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  cpf varchar(255) DEFAULT NULL,
  age int NOT NULL,
  gender varchar(255) DEFAULT NULL,
  status varchar(25) DEFAULT 'EM ESPERA',
  hospital_id int DEFAULT NULL,
  PRIMARY KEY (patient_id),
  KEY FKavr69byb4acg3j289g1oq08pk (hospital_id),
  CONSTRAINT FKavr69byb4acg3j289g1oq08pk FOREIGN KEY (hospital_id) REFERENCES hospitals (hospital_id)
);