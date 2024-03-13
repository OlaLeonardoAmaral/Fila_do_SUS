package br.com.impacta.filadosus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.dto.PatientDto;
import br.com.impacta.filadosus.exception.errors.PatientAlreadyExistsException;
import br.com.impacta.filadosus.exception.errors.PatientNotFoundException;
import br.com.impacta.filadosus.model.paciente.Hospital;
import br.com.impacta.filadosus.model.paciente.Patient;
import br.com.impacta.filadosus.repository.paciente.HospitalRepository;
import br.com.impacta.filadosus.repository.paciente.PacienteRepository;
import br.com.impacta.filadosus.utils.Utils;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PacienteRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = this.patientRepository.findPatientByCpf(patientDto.getCpf());

        if (patient != null) {
            throw new PatientAlreadyExistsException("Patient already exists.");
        }

        String status = (patientDto.getStatus() == null) ? "EM ESPERA" : patientDto.getStatus();
        patientDto.setStatus(status);

        patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setCpf(patientDto.getCpf());
        patient.setSexo(patientDto.getSexo());
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
            throw new PatientNotFoundException("Patient name " + name + ", not found.");
        }

        return patients;
    }

    @Override
    public PatientDto findPatientByCpf(String cpf) {
        Patient patient = this.patientRepository.findPatientByCpf(cpf);

        if (patient == null) {
            throw new PatientNotFoundException("Patient not found.");
        }

        return new PatientDto(patient);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Patient> patient = this.patientRepository.findById(id);
        if (!patient.isPresent()) {
            throw new PatientNotFoundException("Patient not found.");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto update(Integer id, PatientDto patientDto) {
        var patientOptional = this.patientRepository.findById(id).orElse(null);

        if (patientOptional == null) {
            throw new PatientNotFoundException("Patient not found.");
        }

        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setCpf(patientDto.getCpf());
        patient.setSexo(patientDto.getSexo());
        patient.setStatus(patientDto.getStatus()); 

        Utils.copyNonNullProperties(patientDto, patientOptional); 

        return new PatientDto(this.patientRepository.save(patientOptional));
    }

}