package com.sistema.de.gestao.de.funcionarios.gestao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FuncionarioRequestDTO {
    private Long IdFuncionario;
    private String nomeFuncionario;
    private String designacaoFuncionario;
    private Double salarioFuncionario;
    private Long numeroTelefoneFuncionario;
    private String enderecoFuncionario;
}
