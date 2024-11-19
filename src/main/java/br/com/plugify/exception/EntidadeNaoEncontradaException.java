package br.com.plugify.exception;

public class EntidadeNaoEncontradaException extends Exception{
    public EntidadeNaoEncontradaException(){

    }

    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
