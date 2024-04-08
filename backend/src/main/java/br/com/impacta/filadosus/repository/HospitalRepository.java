package br.com.impacta.filadosus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.domain.hospital.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findHospitalByNameContainingIgnoreCase(String name);
}
