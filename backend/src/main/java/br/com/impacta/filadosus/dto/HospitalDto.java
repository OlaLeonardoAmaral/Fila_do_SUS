package br.com.impacta.filadosus.dto;

import java.util.List;

import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Integer hospitalId;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private String numero;
    private List<Paciente> pacientes; 

    public HospitalDto(Hospital hospital) {
        hospitalId = hospital.getHospitalId();
        nome       = hospital.getNome();
        endereco   = hospital.getEndereco();
        bairro     = hospital.getBairro();
        cep        = hospital.getCep();
        numero     = hospital.getNumero();
        pacientes  = hospital.getPacientes();
    }
}
