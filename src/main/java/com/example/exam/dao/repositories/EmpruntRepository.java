package com.example.exam.dao.repositories;

import com.example.exam.dao.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {
    public List<Emprunt> findAllbyUtilisateurId(Integer id);
    public Emprunt findByUtilisateurId(Integer id);
}
