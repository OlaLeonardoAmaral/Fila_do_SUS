package br.com.impacta.filadosus.domain.patient;

import br.com.impacta.filadosus.domain.hospital.Hospital;
import br.com.impacta.filadosus.dto.patient.PatientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "patients")
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String name;
    private int age;
    private String cpf;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(columnDefinition = "varchar(25) default 'EM ESPERA'")
    private String status;

    public Patient(String name, int age, String cpf, String gender, Hospital hospital, String status) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.gender = gender;
        this.hospital = hospital;
        this.status = status;
    }

    public Patient(PatientDTO dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.cpf = dto.getCpf();
        this.gender = dto.getGender();
        this.hospital = dto.getHospital();
        this.status = dto.getStatus();
    }
}
