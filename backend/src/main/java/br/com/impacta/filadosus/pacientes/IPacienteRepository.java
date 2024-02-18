package br.com.impacta.filadosus.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer>{
    
}
