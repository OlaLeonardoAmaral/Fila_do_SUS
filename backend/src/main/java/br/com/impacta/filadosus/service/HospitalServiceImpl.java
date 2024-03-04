package br.com.impacta.filadosus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.HospitalDto;
import br.com.impacta.filadosus.repository.paciente.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<HospitalDto> findAll() {
        return this.hospitalRepository.findAll()
                .stream()
                .map(HospitalDto::new)
                .collect(Collectors.toList());

    }

    @Override
    public List<HospitalDto> findHospitalByNomeContainingIgnoreCase(String nome) {
        return this.hospitalRepository.findHospitalByNomeContainingIgnoreCase(nome)
                .stream()
                .map(HospitalDto::new)
                .collect(Collectors.toList());
    }

}
