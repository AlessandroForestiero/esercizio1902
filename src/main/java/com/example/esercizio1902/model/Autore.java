package com.example.esercizio1902.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "autore")
    private List<BlogPost> posts;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;

    }

    public Autore(){

    }


}
