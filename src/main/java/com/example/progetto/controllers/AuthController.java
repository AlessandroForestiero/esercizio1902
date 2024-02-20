package com.example.progetto.controllers;

import com.example.progetto.entities.Utente;
import com.example.progetto.exceptions.BadRequestException;
import com.example.progetto.exceptions.LoginFaultException;
import com.example.progetto.exceptions.NotFoundException;
import com.example.progetto.requests.LoginRequest;
import com.example.progetto.requests.UtenteRequest;
import com.example.progetto.security.JwtTools;
import com.example.progetto.services.UtenteService;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private JwtTools jwtTools;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/auth/register")
    public Utente register(@RequestBody @Validated UtenteRequest utenteRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return utenteService.save(utenteRequest);

    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Utente utente = utenteService.getUtenteByUsername(loginRequest.getUsername());

        if (encoder.matches(loginRequest.getPassword(),utente.getPassword())) {
            return jwtTools.createToken(utente);
        } else {
            throw new LoginFaultException("username/password errate");
        }


    }
}
