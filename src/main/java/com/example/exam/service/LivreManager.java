package com.example.exam.service;

import com.example.exam.dao.entities.Livre;
import com.example.exam.dao.repositories.LivreRepository;
import com.example.exam.dto.LivreDto;
import com.example.exam.mappers.LivreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreManager implements LivreService {
    @Autowired
    private LivreMapper livreMapper;
    @Autowired
    private LivreRepository livreRepository;

    @Override
    public LivreDto AddLivre(LivreDto livreDto) {
        Livre livre = livreMapper.fromLivreDtoToLivre(livreDto);
        livre = livreRepository.save(livre);
        return livreMapper.fromLivreToLivreDto(livre);
    }

    @Override
    public LivreDto GetLivreByTitre(String titre) {
        Livre livre = livreRepository.findByTitre(titre);
        return livreMapper.fromLivreToLivreDto(livre);
    }

    @Override
    public List<LivreDto> GetLivres() {
        List<Livre> livres = livreRepository.findAll();
        return livres.stream().map(livreMapper::fromLivreToLivreDto).toList();
    }
    @Override
    public LivreDto GetLivreById(Integer id) {
        Livre livre = livreRepository.findById(id).orElse(null);
        return livreMapper.fromLivreToLivreDto(livre);
    }
}