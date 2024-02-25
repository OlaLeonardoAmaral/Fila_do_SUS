package br.com.impacta.filadosus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.filadosus.dto.PacienteDto;
import br.com.impacta.filadosus.service.PacienteService;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/adicionar")
    public ResponseEntity<PacienteDto> create(@Valid @RequestBody PacienteDto pacienteDto) {
        PacienteDto pacienteCreated = pacienteService.save(pacienteDto);
        return ResponseEntity.ok().body(pacienteCreated);
    }

    @GetMapping("/")
    public ResponseEntity<List<PacienteDto>> list() {
        List<PacienteDto> pacientes = pacienteService.findAll();
        return ResponseEntity.ok().body(pacientes);
    }


    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PacienteDto>> findByNome(@PathVariable String nome) {
        List<PacienteDto> paciente = pacienteService.findPacienteByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok().body(paciente);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PacienteDto> findByCpf(@PathVariable String cpf) {
        var paciente = pacienteService.findPacienteByCpf(cpf);
        return ResponseEntity.ok().body(paciente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){  
        pacienteService.deleteById(id);  
        return ResponseEntity.ok().body("Paciente deletado"); 
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> update(@PathVariable Integer id, @RequestBody PacienteDto paciente) {
        return ResponseEntity.ok().body(pacienteService.update(id, paciente));
    }
}
