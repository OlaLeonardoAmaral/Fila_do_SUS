package br.com.impacta.filadosus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.PacienteDto;
import br.com.impacta.filadosus.exception.errors.PacienteAlreadyExistsException;
import br.com.impacta.filadosus.exception.errors.PacienteNotFoundException;
import br.com.impacta.filadosus.model.paciente.Paciente;
import br.com.impacta.filadosus.repository.paciente.PacienteRepository;
import br.com.impacta.filadosus.utils.Utils;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public PacienteDto save(PacienteDto pacienteDto) {
        Paciente paciente = this.pacienteRepository.findPacienteByCpf(pacienteDto.getCpf());

        if (paciente != null) {
            throw new PacienteAlreadyExistsException("Paciente já existe");
        }

        String status = (pacienteDto.getStatus() == null) ? "EM ESPERA" : pacienteDto.getStatus();
        pacienteDto.setStatus(status);

        paciente = new Paciente();
        paciente.setNome(pacienteDto.getNome());
        paciente.setIdade(pacienteDto.getIdade());
        paciente.setCpf(pacienteDto.getCpf());
        paciente.setSexo(pacienteDto.getSexo());
        paciente.setStatus(pacienteDto.getStatus());
        paciente.setHospital(pacienteDto.getHospital());

        paciente = this.pacienteRepository.save(paciente);

        return new PacienteDto(paciente);
    }

    @Override
    public List<PacienteDto> findAll() {

        return this.pacienteRepository.findAll()
                .stream()
                .map(PacienteDto::new) // cria um objeto PacienteDto para cada objeto Paciente da lista
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDto> findPacienteByNomeContainingIgnoreCase(String nome) {

        var pacientes = this.pacienteRepository.findPacienteByNomeContainingIgnoreCase(nome)
                .stream()
                .map(PacienteDto::new)
                .collect(Collectors.toList());

        if (pacientes.isEmpty()) {
            throw new PacienteNotFoundException("O paciente com o Nome " + nome + ", não foi encontrado");
        }

        return pacientes;
    }

    @Override
    public PacienteDto findPacienteByCpf(String cpf) {
        Paciente paciente = this.pacienteRepository.findPacienteByCpf(cpf);

        if (paciente == null) {
            throw new PacienteNotFoundException("Paciente não encontrado.");
        }

        return new PacienteDto(paciente);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Paciente> paciente = this.pacienteRepository.findById(id);
        if (!paciente.isPresent()) {
            throw new PacienteNotFoundException("Paciente não encontrado.");
        }
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDto update(Integer id, PacienteDto pacienteDto) {
        var pacienteOptional = this.pacienteRepository.findById(id).orElse(null);

        if (pacienteOptional == null) {
            throw new PacienteNotFoundException("Paciente não encontrado.");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDto.getNome());
        paciente.setIdade(pacienteDto.getIdade());
        paciente.setCpf(pacienteDto.getCpf());
        paciente.setSexo(pacienteDto.getSexo());
        paciente.setStatus(pacienteDto.getStatus()); 

        Utils.copyNonNullProperties(pacienteDto, pacienteOptional); 

        return new PacienteDto(this.pacienteRepository.save(pacienteOptional));
    }

}