package com.sistema.de.gestao.de.funcionarios.gestao.exception;

import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.NenhumUsuarioCadastradoException;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioJaAdicionadoException;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class Exception {

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, java.lang.NullPointerException.class})
    protected ResponseEntity<String> dadosInvalidosDeRequest(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body("Verifique os dados e tente novamente.");
    }

    @ExceptionHandler(value = {UsuarioJaAdicionadoException.class})
    protected ResponseEntity<String> usuarioJaAdicionado(UsuarioJaAdicionadoException usuarioJaAdicionadoException, WebRequest request) {
        return ResponseEntity.status(409).body(usuarioJaAdicionadoException.getMessage());
    }

    @ExceptionHandler(value = {UsuarioNaoEncontradoException.class})
    protected ResponseEntity<String> usuarioNaoEncontradoException(UsuarioNaoEncontradoException usuarioNaoEncontradoException, WebRequest request) {
        return ResponseEntity.status(404).body(usuarioNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(value = {NenhumUsuarioCadastradoException.class})
    protected ResponseEntity nenhumUsuarioCadastrado(NenhumUsuarioCadastradoException nenhumUsuarioCadastrado, WebRequest request) {
        return ResponseEntity.status(204).build();
    }
}
