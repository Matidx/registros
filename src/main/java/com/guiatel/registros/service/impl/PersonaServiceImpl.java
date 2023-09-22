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

    @Override
    public List<PersonaDTO> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.personasToPersonaDTOs(personas);
    }

    @Override
    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        // Mapea la PersonaDTO a una entidad Persona
        Persona persona = personaMapper.personaDTOToPersona(personaDTO);

        // Guarda la entidad Persona en la base de datos
        persona = personaRepository.save(persona);

        // Mapea la entidad Persona nuevamente a PersonaDTO y devuelve
        return personaMapper.personaToPersonaDTO(persona);
    }

    @Override
    public List<PersonaDTO> filterPersonasByIdOrName(Long id, String name) {
        List<Persona> personas = personaRepository.findByIdOrNameContaining(id, name);
        return personaMapper.personasToPersonaDTOs(personas);
    }

    @Override
    public List<PersonaDTO> getPersonasSortedByAge(boolean ascending) {
        List<Persona> personas = ascending
                ? personaRepository.findByOrderByAgeAsc()
                : personaRepository.findByOrderByAgeDesc();
        return personaMapper.personasToPersonaDTOs(personas);
    }

}

