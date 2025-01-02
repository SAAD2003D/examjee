package com.example.exam.service;

import com.example.exam.dao.entities.Utilisateur;
import com.example.exam.dao.repositories.UtilisateurRepository;
import com.example.exam.dto.UtilisateurDto;
import com.example.exam.mappers.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurManager implements UtilisateurService {
    @Autowired
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto AddUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurMapper.fromUtilisateurDTOtoUtilisateur(utilisateurDto);
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.fromUtilisateurtoUtilisateurDTO(utilisateur);
    }

    @Override
    public UtilisateurDto GetUtilisateur(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return utilisateurMapper.fromUtilisateurtoUtilisateurDTO(utilisateur);
    }

    @Override
    public List<UtilisateurDto> GetUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateurMapper::fromUtilisateurtoUtilisateurDTO).toList();
    }
}