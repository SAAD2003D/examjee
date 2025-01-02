package com.example.exam.mappers;

import com.example.exam.dao.entities.Livre;
import com.example.exam.dto.LivreDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LivreMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public LivreDto fromLivreToLivreDto(Livre livre) {
        return modelMapper.map(livre, LivreDto.class);
    }
    public Livre fromLivreDtoToLivre(LivreDto livreDto) {
        return modelMapper.map(livreDto, Livre.class);
    }
}
