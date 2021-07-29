package br.com.zupacademy.casadocodigo.controllers.exceptions;

import java.util.NoSuchElementException;

public class IdNaoEncontrado extends NoSuchElementException {

    public IdNaoEncontrado(Object elemento){
        super("O elemento " + elemento + " não foi encontrado");
    }

}
