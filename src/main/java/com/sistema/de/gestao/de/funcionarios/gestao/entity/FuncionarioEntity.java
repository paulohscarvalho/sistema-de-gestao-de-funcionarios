package com.sistema.de.gestao.de.funcionarios.gestao.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Data
public class FuncionarioEntity {

    @NonNull
    private Long IdFuncionario;

    @NonNull
    private String nomeFuncionario;

    @NonNull
    private String designacaoFuncionario;

    @NonNull
    private Double salarioFuncionario;

    @NonNull
    private Long numeroTelefoneFuncionario;

    @NonNull
    private String enderecoFuncionario;
}
