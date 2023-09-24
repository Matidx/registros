package com.guiatel.registros.mapper;

import com.guiatel.registros.dto.PersonaDTO;
import com.guiatel.registros.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "job", source = "job"),
            @Mapping(target = "cumpleanito", source = "birthdate"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "description", source = "description")
    })
    PersonaDTO personaToPersonaDTO(Persona persona);


    @InheritInverseConfiguration
    Persona personaDTOToPersona(PersonaDTO personaDTO);
    List<PersonaDTO> personasToPersonaDTOs(List<Persona> personas);
    List<Persona> personaDTOsToPersonas(List<PersonaDTO> personaDTOs);

    // Puedes agregar otros métodos de mapeo personalizados si es necesario
}

