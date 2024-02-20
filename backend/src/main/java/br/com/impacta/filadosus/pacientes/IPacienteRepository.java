package br.com.impacta.filadosus.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer>{
    List<PacienteEntity> findPacienteByNomeContainingIgnoreCase(String nome);
    PacienteEntity findPacienteByCpf(String cpf);
}
