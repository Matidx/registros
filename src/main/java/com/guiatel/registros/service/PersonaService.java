package com.guiatel.registros.service;

import com.guiatel.registros.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> getAllPersonas();
    PersonaDTO savePersona(PersonaDTO personaDTO);
    List<PersonaDTO> filterPersonasByIdOrName(Long id, String name);
    List<PersonaDTO> getPersonasSortedByAge(boolean ascending);
}
