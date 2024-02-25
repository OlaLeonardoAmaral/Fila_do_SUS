package br.com.impacta.filadosus.dto;

import br.com.impacta.filadosus.model.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    
    private Integer id;
    private String nome;
    private int idade;
    private String cpf;
    private String sexo;
    private String status;
    
    public PacienteDto(Paciente paciente) {
        id     = paciente.getId();
        nome   = paciente.getNome();
        idade  = paciente.getIdade();
        cpf    = paciente.getCpf();
        sexo   = paciente.getSexo();
        status = paciente.getStatus();
    }
    
    
}
