package com.guiatel.registros.service;

import com.guiatel.registros.dto.PersonaDTO;
import com.guiatel.registros.entity.Persona;
import com.guiatel.registros.mapper.PersonaMapper;
import com.guiatel.registros.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Autowired
    public PersonaService(PersonaRepository personaRepository, PersonaMapper personaMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.personasToPersonaDTOs(personas);
    }

    public PersonaDTO getPersonaById(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return personaMapper.personaToPersonaDTO(persona);
    }

    public void savePersona(PersonaDTO personaDTO) {
        Persona persona = personaMapper.personaDTOToPersona(personaDTO);
        personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}

