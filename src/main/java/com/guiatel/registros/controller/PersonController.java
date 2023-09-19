package com.guiatel.registros.controller;

import com.guiatel.registros.entity.Person;
import com.guiatel.registros.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAll (){
        return ResponseEntity.ok(this.personService.getAllPersons());
    }

    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person person) {
            return ResponseEntity.ok(this.personService.save(person));
    }
}
