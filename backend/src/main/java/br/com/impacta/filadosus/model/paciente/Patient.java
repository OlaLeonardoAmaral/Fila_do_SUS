package br.com.impacta.filadosus.model.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @NotBlank(message = "'Name' is required.")
    private String name;
    private int age;

    // @CPF(message = "CPF inválido.")
    private String cpf;
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(columnDefinition = "varchar(25) default 'EM ESPERA'")
    private String status;
}
