package br.com.impacta.filadosus.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.filadosus.pacientes.errors.PacienteNotFoundException;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {
 
    @Autowired
    IPacienteRepository pacienteRepository;


    @PostMapping("/adicionar")
    public ResponseEntity<?> create(@Valid @RequestBody PacienteEntity pessoaEntity) {

        PacienteEntity pessoa = this.pacienteRepository.findPacienteByCpf(pessoaEntity.getCpf());
        if (pessoa != null) {
            return ResponseEntity.badRequest().body("Paciente já existe.");
        }

        String status = (pessoaEntity.getStatus() == null) ? "EM ESPERA" : pessoaEntity.getStatus();

        pessoaEntity.setStatus(status);
        var pessoaCreated = pacienteRepository.save(pessoaEntity);
        return ResponseEntity.ok().body(pessoaCreated);
    }

    @GetMapping("/")
    public ResponseEntity<?> list() {
        var pacientes = pacienteRepository.findAll();
        return ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findByNome(@PathVariable String nome) {
        var paciente = pacienteRepository.findPacienteByNomeContainingIgnoreCase(nome);

        if (paciente.isEmpty()) {
            throw new PacienteNotFoundException("Paciente não encontrado.");
        }

        return ResponseEntity.ok().body(paciente);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
        var paciente = pacienteRepository.findPacienteByCpf(cpf);
        
        if (paciente == null) {
            throw new PacienteNotFoundException("Paciente não encontrado.");
        }
        return ResponseEntity.ok().body(paciente);
    }
    
    
    
}
