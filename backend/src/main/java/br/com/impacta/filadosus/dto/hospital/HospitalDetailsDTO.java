package br.com.impacta.filadosus.dto.hospital;

import java.util.List;

public record HospitalDetailsDTO(Integer hospitalId, String name, String address, String neighborhood, String cep,
        String number, List<HospitalPatientDetailsDTO> patients) {
}
