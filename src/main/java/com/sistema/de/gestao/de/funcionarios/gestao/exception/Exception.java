package com.sistema.de.gestao.de.funcionarios.gestao.exception;

import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioJaAdicionadoException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class Exception {

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, java.lang.NullPointerException.class})
    protected ResponseEntity<String> dadosInválidosDeRequest(RuntimeException ex, WebRequest request) {
        return  ResponseEntity.badRequest().body("Verifique os dados e tente novamente.");
    }

    @ExceptionHandler(value = {UsuarioJaAdicionadoException.class})
    protected ResponseEntity<String> usuarioJaAdicionado(UsuarioJaAdicionadoException usuarioJaAdicionadoException, WebRequest request) {
        return  ResponseEntity.badRequest().body(usuarioJaAdicionadoException.getMessage());
    }
}
