package com.guiatel.registros.service;

import com.guiatel.registros.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> getAllPersonas();
    List<PersonaDTO> filterPersonasByIdOrName(Long id, String name);
    List<PersonaDTO> getPersonasSortedByAge(boolean ascending);
    List<PersonaDTO> getAllPersonasOrderedByAgeAndName();
    PersonaDTO savePersona(PersonaDTO personaDTO);
    PersonaDTO updatePersona(Long id, PersonaDTO personaDTO);
    void deletePersona(Long id);
}
