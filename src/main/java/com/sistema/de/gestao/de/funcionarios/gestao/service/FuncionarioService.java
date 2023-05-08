package com.sistema.de.gestao.de.funcionarios.gestao.service;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;

import java.util.Map;

public interface FuncionarioService {

    public Map<Long, FuncionarioEntity> insertFuncionario(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioRequestDTO);

    public Map<Long, FuncionarioEntity> getFuncionarios();

    public Map<Long, FuncionarioEntity> getFuncionarioById();

    public Map<Long, FuncionarioEntity> updateFuncionarioById();

    public Map<Long, FuncionarioEntity> deleteFuncionarioById();
}
