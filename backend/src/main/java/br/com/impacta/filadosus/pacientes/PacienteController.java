package br.com.impacta.filadosus.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
 
    @Autowired
    IPacienteRepository pessoaRepository;


    @PostMapping("/add")
    public ResponseEntity<PacienteEntity> create(@RequestBody PacienteEntity pessoa) {
        pessoa.setStatus("EM ESPERA");
        var pessoaCreated = pessoaRepository.save(pessoa);
        return ResponseEntity.ok().body(pessoaCreated);
    }
}
