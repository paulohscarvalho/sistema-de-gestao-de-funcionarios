package com.sistema.de.gestao.de.funcionarios.gestao.repository;

import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class FuncionarioRepository {

    public Map<Long, FuncionarioEntity> insertFuncionario(Map<Long, FuncionarioEntity> funcionarios, FuncionarioEntity funcionarioEntity) {
        funcionarios.put(funcionarioEntity.getIdFuncionario(), funcionarioEntity);
        return funcionarios;
    }
}
