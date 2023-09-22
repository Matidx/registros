package com.guiatel.registros.repository;

import com.guiatel.registros.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findById(Long id);

    // Query Method para buscar personas por ID o nombre que contiene
    List<Persona> findByIdOrNameContaining(Long id, String name);

    // Query Method para buscar personas por edad, ordenadas por edad ascendente
    List<Persona> findByOrderByAgeAsc();

    // Query Method para buscar personas por edad, ordenadas por edad descendente
    List<Persona> findByOrderByAgeDesc();
    //devolverá una lista de personas ordenadas primero por edad ascendente y luego por nombre ascendente
    List<Persona> findAllByOrderByAgeAscNameAsc();
}

