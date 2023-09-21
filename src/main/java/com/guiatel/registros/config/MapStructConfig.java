package com.guiatel.registros.config;

import com.guiatel.registros.mapper.PersonaMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public PersonaMapper personaMapper() {
        return Mappers.getMapper(PersonaMapper.class);
    }
}
