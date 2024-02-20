package com.example.esercizio1902.controller;


import it.epicode.w7d1t.exception.BadRequestException;
import it.epicode.w7d1t.model.Autore;
import it.epicode.w7d1t.model.AutoreRequest;
import it.epicode.w7d1t.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;
//    @Autowired
//    private Cloudinary cloudinary;
    @GetMapping("/autori")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Autore> getAll(Pageable pageable){

        return autoreService.cercaTuttiGliAutori(pageable);
    }
    @GetMapping("/autori/{id}")
    public Autore getAutoreById(@PathVariable int id){
        return autoreService.cercaAutorePerId(id);

    }
    @PostMapping("/autori")
    public Autore saveAutore(@RequestBody @Validated AutoreRequest autoreRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return autoreService.salvaAutore(autoreRequest);
    }
    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody @Validated AutoreRequest autoreRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return autoreService.aggiornaAutore(id, autoreRequest);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id){
        autoreService.cancellaAutore(id);
    }

//    @PatchMapping("/autori/{id}/upload")
//    public Autore uploadAvatar(@PathVariable int id, @RequestParam("upload") MultipartFile file) throws IOException {
//        return autoreService.uploadAvatar(id,
//                (String) cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
//
//    }
}
