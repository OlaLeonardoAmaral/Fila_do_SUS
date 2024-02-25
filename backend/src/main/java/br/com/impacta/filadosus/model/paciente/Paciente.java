package br.com.impacta.filadosus.model.paciente;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    private int idade;

    @CPF(message = "CPF inválido.")
    private String cpf;
    private String sexo;

    @Column(columnDefinition = "varchar(25) default 'EM ESPERA'")
    private String status;
}
