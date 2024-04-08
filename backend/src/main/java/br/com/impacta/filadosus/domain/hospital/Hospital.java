package br.com.impacta.filadosus.domain.hospital;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.impacta.filadosus.domain.patient.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "hospitals")
public class Hospital {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;
    private String name;
    private String address;
    private String neighborhood;
    private String cep;
    private String number;

    @JsonIgnore
    @OneToMany(mappedBy = "hospital")
    private List<Patient> patients;
}
