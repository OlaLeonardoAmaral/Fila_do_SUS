package br.com.impacta.filadosus.dto.hospital;

public record HospitalPatientDetailsDTO(Integer patientId, String name, int age, String cpf,
        String gender, String status) {
}
