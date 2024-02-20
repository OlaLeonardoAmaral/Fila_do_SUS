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



@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {
 
    @Autowired
    IPacienteRepository pacienteRepository;


    @PostMapping("/adicionar")
    public ResponseEntity<PacienteEntity> create(@RequestBody PacienteEntity pessoa) {
        pessoa.setStatus("EM ESPERA");
        var pessoaCreated = pacienteRepository.save(pessoa);
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
        return ResponseEntity.ok().body(paciente);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
        var teste = pacienteRepository.findPacienteByCpf(cpf);
        return ResponseEntity.ok().body(teste);
    }
    
    
    
}
