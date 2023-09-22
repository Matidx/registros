package com.guiatel.registros.controller;

import com.guiatel.registros.dto.PersonaDTO;
import com.guiatel.registros.service.impl.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaServiceImpl personaService;

    @Autowired
    public PersonaController(PersonaServiceImpl personaService) {
        this.personaService = personaService;
    }


    @GetMapping
    public List<PersonaDTO> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public PersonaDTO getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> createPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO savedPersona = personaService.savePersona(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
}
