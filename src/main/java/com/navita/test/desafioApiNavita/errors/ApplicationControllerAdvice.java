package com.navita.test.desafioApiNavita.errors;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException ex){

        BindingResult bindingResult = ex.getBindingResult();

       List<String>messages =  bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());


       return new ApiErrors(messages);
    }


    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResp validacao(ResponseStatusException exception){
        ErroResp erroResp = new ErroResp();
        String erro = exception.getMessage();
        HttpStatus httpStatus = exception.getStatus();
        erroResp.setMessage(erro);
        erroResp.setStatus(httpStatus);
        return erroResp;
    }

    @ExceptionHandler(TesteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TesteException teste(TesteException testeException){
        return testeException;
    }

}
