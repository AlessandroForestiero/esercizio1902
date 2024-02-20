package com.example.progetto.requests;

import com.example.progetto.enums.Status;
import com.example.progetto.enums.Tipo;
import lombok.Data;


@Data
public class DispositivoPatchRequest {
    private Status status;
    private Tipo tipo;
    private Integer dipendenteId;
}
