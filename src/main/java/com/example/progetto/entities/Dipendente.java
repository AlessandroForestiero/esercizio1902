package com.example.progetto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_dipendente")
    @SequenceGenerator(name="sequenza_dipendente",initialValue = 1,allocationSize = 1)
    private int id;
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String username;
    private String email;
    private String fotoProfilo;
    @JsonIgnore
    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> listaDispositivi;
}
