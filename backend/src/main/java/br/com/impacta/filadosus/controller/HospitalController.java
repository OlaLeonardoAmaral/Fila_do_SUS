package br.com.impacta.filadosus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.filadosus.dto.HospitalDto;
import br.com.impacta.filadosus.service.HospitalService;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "*")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/")
    public ResponseEntity<List<HospitalDto>> list() {
        List<HospitalDto> hospitals = hospitalService.findAll();
        return ResponseEntity.ok().body(hospitals);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<HospitalDto>> findByName(@PathVariable String name) {
        List<HospitalDto> hospital = hospitalService.findHospitalByNameContainingIgnoreCase(name);
        return ResponseEntity.ok().body(hospital);
    }
}
