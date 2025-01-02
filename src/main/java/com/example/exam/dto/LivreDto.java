package com.example.exam.dto;

import com.example.exam.dao.entities.TypeStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link com.example.exam.dao.entities.Livre}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivreDto {

    private Integer id;
    @NotEmpty
    private String titre;
    @NotEmpty
    private String auteur;
    @NotEmpty
    private String isbn;
    @NotNull
    private Date datPublication;
    @NotNull
    private TypeStatus statut;
    private UtilisateurDto utilisateur;
    private List<EmpruntDto> emprunts;
}