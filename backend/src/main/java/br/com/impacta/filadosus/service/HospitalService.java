package br.com.impacta.filadosus.service;

import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.hospital.HospitalListResponseDTO;

@Service
public interface HospitalService {
    HospitalListResponseDTO findAll();
    HospitalListResponseDTO findHospitalByNameContainingIgnoreCase(String name);
}
