package com.guiatel.registros.repository;

import com.guiatel.registros.entity.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<Person,Long> {
}
