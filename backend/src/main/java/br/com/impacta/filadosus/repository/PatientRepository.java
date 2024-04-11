package br.com.impacta.filadosus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.domain.patient.Patient;

import java.util.List;
import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Integer>{
    List<Patient> findPatientByNameContainingIgnoreCase(String nome);
    Optional<Patient> findPatientByCpf(String cpf);
}
