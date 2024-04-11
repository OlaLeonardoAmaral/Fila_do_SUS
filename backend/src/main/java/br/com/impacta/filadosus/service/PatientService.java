package br.com.impacta.filadosus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.patient.PatientDTO;

@Service
public interface PatientService {
    PatientDTO save(PatientDTO patientDto);

    List<PatientDTO> findAll();

    List<PatientDTO> findPatientByNameContainingIgnoreCase(String name);
    
    PatientDTO findPatientByCpf(String cpf);

    PatientDTO update(Integer id, PatientDTO pacienteDto);

    void deleteById(Integer id);
}