package br.com.impacta.filadosus.dto;

import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    
    private Integer pacienteId;
    private String nome;
    private int idade;
    private String cpf;
    private String sexo;
    private String status;
    private Hospital hospital;
    
    public PacienteDto(Paciente paciente) {
        pacienteId = paciente.getPacienteId();
        nome       = paciente.getNome();
        idade      = paciente.getIdade();
        cpf        = paciente.getCpf();
        sexo       = paciente.getSexo();
        status     = paciente.getStatus();
        hospital   = paciente.getHospital();
    }
    
    
}
