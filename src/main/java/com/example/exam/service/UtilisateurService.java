package com.example.exam.service;

import com.example.exam.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    public UtilisateurDto AddUtilisateur(UtilisateurDto utilisateurDto);
    public UtilisateurDto GetUtilisateur(Integer id);
    public List<UtilisateurDto> GetUtilisateurs();

}
