package com.sistema.de.gestao.de.funcionarios.gestao.exception.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UsuarioJaAdicionadoException extends RuntimeException {
    public UsuarioJaAdicionadoException() {
        super("O usuário indicado já existe na base de dados");
    }
}
