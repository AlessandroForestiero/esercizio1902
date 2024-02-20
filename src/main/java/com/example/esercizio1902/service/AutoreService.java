package com.example.esercizio1902.service;

import it.epicode.w7d1t.exception.NotFoundException;
import it.epicode.w7d1t.model.Autore;
import it.epicode.w7d1t.model.AutoreRequest;
import it.epicode.w7d1t.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public Page<Autore> cercaTuttiGliAutori(Pageable pageable){

        return autoreRepository.findAll(pageable);
    }

    public Autore cercaAutorePerId(int id){
        return autoreRepository.findById(id).
                orElseThrow(()->new NotFoundException("Autore con id="+ id + " non trovato"));
    }

    public Autore salvaAutore(AutoreRequest autoreRequest){
        Autore autore = new Autore(autoreRequest.getNome(), autoreRequest.getCognome(), autoreRequest.getEmail(), autoreRequest.getDataNascita());
        return autoreRepository.save(autore);
    }

    public Autore aggiornaAutore(int id, AutoreRequest autoreRequest) throws NotFoundException{
        Autore a = cercaAutorePerId(id);

        a.setNome(autoreRequest.getNome());
        a.setCognome(autoreRequest.getCognome());
        a.setEmail(autoreRequest.getEmail());
        a.setDataNascita(autoreRequest.getDataNascita());

        return autoreRepository.save(a);
    }

    public void cancellaAutore(int id) throws NotFoundException{
        Autore a = cercaAutorePerId(id);

        autoreRepository.delete(a);
    }

    public Autore uploadAvatar(int id, String url){
        Autore autore = cercaAutorePerId(id);
        autore.setAvatar(url);
        return autoreRepository.save(autore);
    }
}
