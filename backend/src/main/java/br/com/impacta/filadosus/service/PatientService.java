package br.com.impacta.filadosus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.PatientDto;

@Service
public interface PatientService {
    PatientDto save(PatientDto patientDto);

    List<PatientDto> findAll();

    List<PatientDto> findPatientByNameContainingIgnoreCase(String name);
    
    PatientDto findPatientByCpf(String cpf);

    PatientDto update(Integer id, PatientDto pacienteDto);

    void deleteById(Integer id);
}