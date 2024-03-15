package br.com.impacta.filadosus.dto;

import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Patient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    
    private Integer patientId;

    // @Valid

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
    private String status;

    private Hospital hospital;
    
    public PatientDto(Patient paciente) {
        patientId = paciente.getPatientId();
        name       = paciente.getName();
        age      = paciente.getAge();
        cpf        = paciente.getCpf();
        gender       = paciente.getGender();
        status     = paciente.getStatus();
        hospital   = paciente.getHospital();
    }
    
    
}
