package com.example.progetto.requests;

import com.example.progetto.enums.Status;
import com.example.progetto.enums.Tipo;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class DispositivoRequest {
    @NotNull(message = "Non può essere null")
    private Status status;
    @NotNull(message = "Non può essere null")
    private Tipo tipo;
    private Integer dipendenteId;
}
