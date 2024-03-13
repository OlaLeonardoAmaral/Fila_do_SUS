package br.com.impacta.filadosus.dto;

import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    
    private Integer patientId;
    private String name;
    private int age;
    private String cpf;
    private String sexo;
    private String status;
    private Hospital hospital;
    
    public PatientDto(Patient paciente) {
        patientId = paciente.getPatientId();
        name       = paciente.getName();
        age      = paciente.getAge();
        cpf        = paciente.getCpf();
        sexo       = paciente.getSexo();
        status     = paciente.getStatus();
        hospital   = paciente.getHospital();
    }
    
    
}
