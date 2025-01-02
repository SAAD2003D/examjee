package com.example.exam.service;

import com.example.exam.dao.entities.Emprunt;
import com.example.exam.dao.repositories.EmpruntRepository;
import com.example.exam.dto.EmpruntDto;
import com.example.exam.mappers.EmpruntMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class EmpruntManager implements EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;
    @Autowired
    private EmpruntMapper empruntMapper;

    @Override
    public EmpruntDto AddEmprunt(EmpruntDto empruntDto) {
        return empruntMapper.fromEmpruntToEmpruntDto(
                empruntRepository.save(
                        empruntMapper.fromEmpruntDtoToEmprunt(empruntDto)));
    }

    @Override
    public EmpruntDto GetEmpruntByUtilisateurId(Integer utilisateurId) {
        Emprunt emprunt = empruntRepository.findByUtilisateurId(utilisateurId);
        return empruntMapper.fromEmpruntToEmpruntDto(emprunt);
    }

    @Override
    public List<EmpruntDto> GetEmprunts() {
        List<Emprunt> emprunts = empruntRepository.findAll();
        return emprunts.stream().map(empruntMapper::fromEmpruntToEmpruntDto).collect(Collectors.toList());
    }
}