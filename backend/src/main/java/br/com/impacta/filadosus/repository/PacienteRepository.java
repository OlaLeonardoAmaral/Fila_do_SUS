package br.com.impacta.filadosus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.domain.patient.Patient;

import java.util.List;


public interface PacienteRepository extends JpaRepository<Patient, Integer>{
    List<Patient> findPatientByNameContainingIgnoreCase(String nome);
    Patient findPatientByCpf(String cpf);
}
