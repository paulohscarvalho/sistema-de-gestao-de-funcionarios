package com.sistema.de.gestao.de.funcionarios.gestao.service;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioResponseDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;

import java.util.Map;
import java.util.Set;

public interface FuncionarioService {

    public Map<Long, FuncionarioEntity> insertFuncionario(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioRequestDTO);

    public Set<Map.Entry<Long, FuncionarioEntity>> getFuncionarios(Map<Long, FuncionarioEntity> funcionarios);

    public FuncionarioResponseDTO getFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, Long id);

    public Map<Long, FuncionarioEntity> updateFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioDTO);

    public Map<Long, FuncionarioEntity> deleteFuncionarioById();
}
