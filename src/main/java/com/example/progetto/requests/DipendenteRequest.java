package com.example.progetto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DipendenteRequest {
    @NotBlank(message = "Non può essere vuoto")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String nome;

    @NotBlank(message = "Non può essere vuoto")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String cognome;

    @NotBlank(message = "Non può essere vuoto")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String username;

    @NotBlank(message = "Non può essere vuoto")
    @Email(message = "Deve essere un'email")
    private String email;
}
