package com.example.exam.mappers;

import com.example.exam.dao.entities.Emprunt;
import com.example.exam.dto.EmpruntDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpruntMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public EmpruntDto fromEmpruntToEmpruntDto(Emprunt emprunt) {
        return modelMapper.map(emprunt, EmpruntDto.class);
    }
    public Emprunt fromEmpruntDtoToEmprunt(EmpruntDto empruntDto) {
        return modelMapper.map(empruntDto, Emprunt.class);
    }
}
