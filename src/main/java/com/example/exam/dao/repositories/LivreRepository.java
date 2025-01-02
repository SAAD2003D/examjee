package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
    public Livre findByTitre(String titre);
}