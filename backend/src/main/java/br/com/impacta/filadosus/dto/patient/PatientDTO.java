package br.com.impacta.filadosus.dto.patient;

import br.com.impacta.filadosus.domain.hospital.Hospital;
import br.com.impacta.filadosus.domain.patient.Patient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    
    private Integer patientId;

    @NotBlank(message = "'Name' is mandatory.")
    @NotNull(message =  "Please, inform the 'name'.")
    private String name;
    
    @Min(value = 1, message = "Please inform a valid 'age'.")
    private int age;
    
    @NotBlank(message = "'CPF' is mandatory.")
    @NotNull(message =  "Please, inform the 'cpf'.")
    private String cpf;

    @NotBlank(message = "'Gender' is mandatory.")
    @NotNull(message =  "Please, inform the 'gender'.")
    private String gender;
    private Hospital hospital;

    private String status;
    
    public PatientDTO(Patient paciente) {
        patientId = paciente.getPatientId();
        name       = paciente.getName();
        age      = paciente.getAge();
        cpf        = paciente.getCpf();
        gender       = paciente.getGender();
        status     = paciente.getStatus();
        hospital   = paciente.getHospital();
    }

    public PatientDTO(String name, int age, String cpf, String gender, Hospital hospital, String status) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.gender = gender;
        this.hospital = hospital;
        this.status = status;
    }
    
}
