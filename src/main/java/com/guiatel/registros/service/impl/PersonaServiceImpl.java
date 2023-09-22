package com.guiatel.registros.service.impl;

import com.guiatel.registros.dto.PersonaDTO;
import com.guiatel.registros.entity.Persona;
import com.guiatel.registros.mapper.PersonaMapper;
import com.guiatel.registros.repository.PersonaRepository;
import com.guiatel.registros.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper personaMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return this.personaMapper.personasToPersonaDTOs(personas);
    }

    public PersonaDTO getPersonaById(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return personaMapper.personaToPersonaDTO(persona);
    }

    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        // Mapea la PersonaDTO a una entidad Persona
        Persona persona = personaMapper.personaDTOToPersona(personaDTO);

        // Guarda la entidad Persona en la base de datos
        persona = personaRepository.save(persona);

        // Mapea la entidad Persona nuevamente a PersonaDTO y devuelve
        return personaMapper.personaToPersonaDTO(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}

