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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.filadosus.dto.patient.PatientCpfDTO;
import br.com.impacta.filadosus.dto.patient.PatientDTO;
import br.com.impacta.filadosus.service.PatientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<PatientDTO> create(@Valid @RequestBody PatientDTO patientDto) {
        PatientDTO patientCreated = patientService.save(patientDto);
        return ResponseEntity.ok().body(patientCreated);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> list() {
        List<PatientDTO> patients = patientService.findAll();
        return ResponseEntity.ok().body(patients);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PatientDTO>> findByName(@PathVariable String name) {
        List<PatientDTO> patient = patientService.findPatientByNameContainingIgnoreCase(name);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/cpf")
    public ResponseEntity<PatientDTO> findByCpf(@RequestParam(name = "cpf") PatientCpfDTO patientCpfDTO) {
        var patient = patientService.findPatientByCpf(patientCpfDTO.cpf());
        return ResponseEntity.ok().body(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        patientService.deleteById(id);
        return ResponseEntity.ok().body("Patient is deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Integer id, @RequestBody PatientDTO patient) {
        return ResponseEntity.ok().body(patientService.update(id, patient));
    }
}
