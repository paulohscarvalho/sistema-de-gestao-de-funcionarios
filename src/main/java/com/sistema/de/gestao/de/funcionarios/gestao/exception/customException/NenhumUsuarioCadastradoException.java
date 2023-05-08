package com.sistema.de.gestao.de.funcionarios.gestao.exception.customException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NenhumUsuarioCadastradoException extends RuntimeException {
    public NenhumUsuarioCadastradoException() {
        super("Nenhum usuário cadastrado");
    }
}
