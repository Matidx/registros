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
    public ResponseEntity<List<PersonaDTO>> getAllPersonas() {
        List<PersonaDTO> personas = personaService.getAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PersonaDTO>> filterPersonas(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        List<PersonaDTO> personas = personaService.filterPersonasByIdOrName(id, name);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<PersonaDTO>> sortPersonas(@RequestParam(required = false, defaultValue = "true") boolean ascending) {
        List<PersonaDTO> personas = personaService.getPersonasSortedByAge(ascending);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> savePersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO savedPersona = personaService.savePersona(personaDTO);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }
    // Método PUT para actualizar una persona por ID
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
            PersonaDTO updatedPersona = personaService.updatePersona(id, personaDTO);
            return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

