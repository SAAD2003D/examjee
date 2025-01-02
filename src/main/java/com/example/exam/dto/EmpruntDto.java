package com.example.exam.dto;

import com.example.exam.dao.entities.Livre;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link com.example.exam.dao.entities.Emprunt}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntDto  {

    private Integer id;
    @NotNull
    private Date dateEmprunt;
    @NotNull
    private Date dateRetourPrevu;
    private UtilisateurDto utilisateur;
    private List<LivreDto> livre;





}