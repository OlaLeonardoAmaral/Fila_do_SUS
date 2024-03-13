package br.com.impacta.filadosus.repository.paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.model.paciente.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findHospitalByNameContainingIgnoreCase(String name);
}
