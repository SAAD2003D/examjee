package com.example.exam.mappers;

import com.example.exam.dao.entities.Utilisateur;
import com.example.exam.dto.UtilisateurDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {

    private final ModelMapper modelMapper = new ModelMapper();
    public UtilisateurDto fromUtilisateurtoUtilisateurDTO(Utilisateur utilisateur) {
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }
    public Utilisateur fromUtilisateurDTOtoUtilisateur(UtilisateurDto utilisateurDto) {
        return modelMapper.map(utilisateurDto, Utilisateur.class);
    }

}
