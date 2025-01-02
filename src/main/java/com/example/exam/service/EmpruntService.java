package com.example.exam.service;

import com.example.exam.dto.EmpruntDto;

import java.util.List;

public interface EmpruntService {
    public EmpruntDto AddEmprunt(EmpruntDto empruntDto);
    public EmpruntDto GetEmpruntByUtilisateurId(Integer utilisateurId);
    public List<EmpruntDto> GetEmprunts();
}
