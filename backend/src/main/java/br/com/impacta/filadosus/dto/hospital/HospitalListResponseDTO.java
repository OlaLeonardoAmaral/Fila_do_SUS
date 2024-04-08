package br.com.impacta.filadosus.dto.hospital;

import java.util.List;

public record HospitalListResponseDTO(List<HospitalDetailsDTO> hospitals) {
}