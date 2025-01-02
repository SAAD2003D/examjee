package com.example.exam.service;

import com.example.exam.dto.LivreDto;

import java.util.List;

public interface LivreService {
    public LivreDto AddLivre(LivreDto livreDto);
    public LivreDto GetLivreByTitre(String titre);
    public List<LivreDto> GetLivres();
    public LivreDto GetLivreById(Integer id);
}
