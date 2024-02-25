package br.com.impacta.filadosus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.PacienteDto;

@Service
public interface PacienteService {
    PacienteDto save(PacienteDto pacienteDto);

    List<PacienteDto> findAll();

    List<PacienteDto> findPacienteByNomeContainingIgnoreCase(String nome);
    
    PacienteDto findPacienteByCpf(String cpf);

    PacienteDto update(Integer id, PacienteDto pacienteDto);

    void deleteById(Integer id);
}