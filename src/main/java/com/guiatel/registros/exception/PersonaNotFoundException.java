package com.guiatel.registros.exception;

public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException(String message) {
        super(message);
    }
}