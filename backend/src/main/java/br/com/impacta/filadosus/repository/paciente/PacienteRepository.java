package br.com.impacta.filadosus.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.filadosus.model.paciente.Paciente;

import java.util.List;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    List<Paciente> findPacienteByNomeContainingIgnoreCase(String nome);
    Paciente findPacienteByCpf(String cpf);
}
