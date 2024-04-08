package br.com.impacta.filadosus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.domain.hospital.Hospital;
import br.com.impacta.filadosus.dto.hospital.HospitalDetailsDTO;
import br.com.impacta.filadosus.dto.hospital.HospitalListResponseDTO;
import br.com.impacta.filadosus.dto.hospital.HospitalPatientDetailsDTO;
import br.com.impacta.filadosus.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public HospitalListResponseDTO findAll() {
        List<Hospital> hospitalList = this.hospitalRepository.findAll();
        return getHospitalDetails(hospitalList);
    }

    @Override
    public HospitalListResponseDTO findHospitalByNameContainingIgnoreCase(String name) {
        List<Hospital> hospitalList = this.hospitalRepository.findHospitalByNameContainingIgnoreCase(name);
        return getHospitalDetails(hospitalList);
    }

    private HospitalListResponseDTO getHospitalDetails(List<Hospital> hospitals) {

        List<HospitalDetailsDTO> hospitalDetailsList = hospitals.stream().map(hospital -> {

            List<HospitalPatientDetailsDTO> patientsDetails = hospital.getPatients().stream().map(patient -> {
                return new HospitalPatientDetailsDTO(patient.getPatientId(), patient.getName(), patient.getAge(),
                        patient.getCpf(), patient.getGender(), patient.getStatus());
            }).toList();

            return new HospitalDetailsDTO(hospital.getHospitalId(), hospital.getName(), hospital.getAddress(),
                    hospital.getNeighborhood(), hospital.getCep(), hospital.getNumber(), patientsDetails);
        }).toList();
        return new HospitalListResponseDTO(hospitalDetailsList);
    }
}
