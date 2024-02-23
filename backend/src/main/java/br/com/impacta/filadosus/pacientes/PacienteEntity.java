package br.com.impacta.filadosus.pacientes;

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
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    private Integer idade;

    @CPF(message = "CPF inválido.")
    private String cpf;

    @Column(columnDefinition = "varchar(25) default 'EM ESPERA'")
    private String status;
}
