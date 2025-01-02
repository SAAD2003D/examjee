package com.example.exam.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.exam.dao.entities.Utilisateur}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto  {

    private Integer id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @Email
    private String email;
    private List<LivreDto> livres;
    private List<EmpruntDto> emprunts;

}