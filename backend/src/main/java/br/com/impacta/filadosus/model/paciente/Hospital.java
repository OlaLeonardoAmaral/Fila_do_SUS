package br.com.impacta.filadosus.model.paciente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "hospitais")
public class Hospital {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private String numero;

    @JsonIgnore
    @OneToMany(mappedBy = "hospital")
    private List<Paciente> pacientes;
}
