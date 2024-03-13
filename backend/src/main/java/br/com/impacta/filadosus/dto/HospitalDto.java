package br.com.impacta.filadosus.dto;

import java.util.List;

import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Integer hospitalId;
    private String name;
    private String address;
    private String neighborhood;
    private String cep;
    private String number;
    private List<Patient> patients; 

    public HospitalDto(Hospital hospital) {
        hospitalId   = hospital.getHospitalId();
        name         = hospital.getName();
        address      = hospital.getAddress();
        neighborhood = hospital.getNeighborhood();
        cep          = hospital.getCep();
        number       = hospital.getNumber();
        patients     = hospital.getPatients();
    }
}
