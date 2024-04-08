package br.com.impacta.filadosus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.domain.hospital.Hospital;
import br.com.impacta.filadosus.domain.patient.Patient;
import br.com.impacta.filadosus.domain.patient.exceptions.PatientAlreadyExistsException;
import br.com.impacta.filadosus.domain.patient.exceptions.PatientNotFoundException;
import br.com.impacta.filadosus.dto.PatientDto;
import br.com.impacta.filadosus.repository.HospitalRepository;
import br.com.impacta.filadosus.repository.PacienteRepository;
import br.com.impacta.filadosus.utils.Utils;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PacienteRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public PatientDto save(PatientDto patientDto) {

        String patientCpf = patientDto.getCpf();
        Patient patient = this.patientRepository.findPatientByCpf(patientCpf);

        if (patient != null) {
            throw new PatientAlreadyExistsException();
        }

        String status = (patientDto.getStatus() == null) ? "EM ESPERA" : patientDto.getStatus();
        patientDto.setStatus(status);

        patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setCpf(patientDto.getCpf());
        patient.setGender(patientDto.getGender());
        patient.setStatus(patientDto.getStatus());

        Integer hospitalId = patientDto.getHospital().getHospitalId();
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(hospitalId);
        
        if(hospitalOptional.isPresent()) {
            Hospital hospital = hospitalOptional.get();
            patient.setHospital(hospital);
        } else {
            System.out.println("Hospital not found");
        }

        patient = this.patientRepository.save(patient);
        return new PatientDto(patient);
    }

    @Override
    public List<PatientDto> findAll() {

        return this.patientRepository.findAll()
                .stream()
                .map(PatientDto::new) // cria um objeto patientDto para cada objeto patient da lista
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> findPatientByNameContainingIgnoreCase(String name) {

        var patients = this.patientRepository.findPatientByNameContainingIgnoreCase(name)
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());

        if (patients.isEmpty()) {
            throw new PatientNotFoundException();
        }

        return patients;
    }

    @Override
    public PatientDto findPatientByCpf(String cpf) {
        Patient patient = this.patientRepository.findPatientByCpf(cpf);

        if (patient == null) {
            throw new PatientNotFoundException();
        }

        return new PatientDto(patient);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Patient> patient = this.patientRepository.findById(id);
        if (!patient.isPresent()) {
            throw new PatientNotFoundException();
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto update(Integer id, PatientDto patientDto) {
        var patientOptional = this.patientRepository.findById(id).orElse(null);

        if (patientOptional == null) {
            throw new PatientNotFoundException();
        }

        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setCpf(patientDto.getCpf());
        patient.setGender(patientDto.getGender());
        patient.setStatus(patientDto.getStatus()); 

        Utils.copyNonNullProperties(patientDto, patientOptional); 

        return new PatientDto(this.patientRepository.save(patientOptional));
    }

}