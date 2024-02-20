package com.example.progetto.repositories;

import com.example.progetto.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface DipendenteRepository extends JpaRepository<Dipendente,Integer>, PagingAndSortingRepository<Dipendente,Integer> {
}
