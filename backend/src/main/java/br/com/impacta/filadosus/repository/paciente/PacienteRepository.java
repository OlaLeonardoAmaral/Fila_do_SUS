package br.com.impacta.filadosus.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.model.paciente.Patient;

import java.util.List;


public interface PacienteRepository extends JpaRepository<Patient, Integer>{
    List<Patient> findPatientByNameContainingIgnoreCase(String nome);
    Patient findPatientByCpf(String cpf);
}
