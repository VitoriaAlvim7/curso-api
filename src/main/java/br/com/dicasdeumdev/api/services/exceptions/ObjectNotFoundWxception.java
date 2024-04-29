package br.com.dicasdeumdev.api.services.exceptions;

public class ObjectNotFoundWxception extends RuntimeException{

    public ObjectNotFoundWxception(String message) {
        super(message);
    }
}
