package com.example.progetto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DipendentePatchRequest {
    @Pattern(regexp = ".*[^ ].*",message = "Nome non valido!")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String nome;

    @Pattern(regexp = ".*[^ ].*",message = "Nome non valido!")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String cognome;

    @Pattern(regexp = ".*[^ ].*",message = "Nome non valido!")
    @Size(min=3,max=15,message = "Deve avere un numero di caratteri compreso tra 3 e 15")
    private String username;

    @Pattern(regexp = ".*[^ ].*",message = "Nome non valido!")
    @Email(message = "Deve essere un'email")
    private String email;
}
