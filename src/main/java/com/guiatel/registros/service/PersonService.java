package com.guiatel.registros.service;

import com.guiatel.registros.entity.Person;
import com.guiatel.registros.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons () {
        return personRepository.findAll();
    }

    public Person save (Person person) {
        return this.personRepository.save(person);
    }
}
