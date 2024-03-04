package br.com.impacta.filadosus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.HospitalDto;

@Service
public interface HospitalService {
    List<HospitalDto> findAll();
    List<HospitalDto> findHospitalByNomeContainingIgnoreCase(String nome);
}
