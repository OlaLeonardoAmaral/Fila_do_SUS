package br.com.impacta.filadosus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.filadosus.domain.hospital.exceptions.HospitalNotFoundException;
import br.com.impacta.filadosus.domain.patient.Patient;
import br.com.impacta.filadosus.domain.patient.exceptions.PatientAlreadyExistsException;
import br.com.impacta.filadosus.domain.patient.exceptions.PatientNotFoundException;
import br.com.impacta.filadosus.dto.patient.PatientDTO;
import br.com.impacta.filadosus.repository.HospitalRepository;
import br.com.impacta.filadosus.repository.PatientRepository;
import br.com.impacta.filadosus.utils.Utils;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public PatientDTO save(PatientDTO patientDto) {

        String patientCpf = patientDto.getCpf();

        this.patientRepository.findPatientByCpf(patientCpf)
                .ifPresent(patient -> {
                    throw new PatientAlreadyExistsException();
                });

        this.verifyHospitalExists(patientDto.getHospital().getHospitalId());

        String status = (patientDto.getStatus() == null) ? "EM ESPERA" : patientDto.getStatus();
        patientDto.setStatus(status);

        Patient patient = this.patientRepository.save(new Patient(patientDto));
        return new PatientDTO(patient);
    }

    @Override
    public List<PatientDTO> findAll() {

        return this.patientRepository.findAll()
                .stream()
                .map(PatientDTO::new) // cria um objeto patientDto para cada objeto patient da lista
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> findPatientByNameContainingIgnoreCase(String name) {

        var patients = this.patientRepository.findPatientByNameContainingIgnoreCase(name)
                .stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());

        if (patients.isEmpty()) {
            throw new PatientNotFoundException();
        }

        return patients;
    }

    @Override
    public PatientDTO findPatientByCpf(String cpf) {
        Patient patient = this.patientRepository.findPatientByCpf(cpf)
                .orElseThrow(() -> new PatientNotFoundException());
        return new PatientDTO(patient);
    }

    @Override
    public void deleteById(Integer id) {
        this.patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException());
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDTO update(Integer id, PatientDTO patientDto) {
        Patient newPatient = this.patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException());

        this.verifyHospitalExists(patientDto.getHospital().getHospitalId());

        Utils.copyNonNullProperties(patientDto, newPatient);

        return new PatientDTO(this.patientRepository.save(newPatient));
    }

    private void verifyHospitalExists(Integer hospitalId) {
        hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new HospitalNotFoundException());
    }

}