package com.navita.test.desafioApiNavita.errors;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(String message){
        super("Senha inválida");
    }
}
