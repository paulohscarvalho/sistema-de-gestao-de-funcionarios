package com.sistema.de.gestao.de.funcionarios.gestao.service.impl;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioJaAdicionadoException;
import com.sistema.de.gestao.de.funcionarios.gestao.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    public Map<Long, FuncionarioEntity> initializateHashMap(Map<Long, FuncionarioEntity> funcionarios) {
        if (funcionarios == null) {
            funcionarios = new HashMap<>();
        }

        return funcionarios;
    }

    @Override
    public Map<Long, FuncionarioEntity> insertFuncionario(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarios = initializateHashMap(funcionarios);

        if (isFuncionarioCadastrado(funcionarios, funcionarioRequestDTO)) {
            throw new UsuarioJaAdicionadoException();
        }

        funcionarios.put(funcionarioRequestDTO.getIdFuncionario(), funcionarioRequestDtoToEntity(funcionarioRequestDTO));

        return funcionarios;
    }

    public boolean isFuncionarioCadastrado(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioRequestDTO) {
        return funcionarios.containsKey(funcionarioRequestDTO.getIdFuncionario());
    }

    public FuncionarioEntity funcionarioRequestDtoToEntity(FuncionarioRequestDTO funcionarioRequestDTO) {
        return FuncionarioEntity
                .builder()
                .IdFuncionario(funcionarioRequestDTO.getIdFuncionario())
                .nomeFuncionario(funcionarioRequestDTO.getNomeFuncionario())
                .designacaoFuncionario(funcionarioRequestDTO.getDesignacaoFuncionario())
                .salarioFuncionario(funcionarioRequestDTO.getSalarioFuncionario())
                .numeroTelefoneFuncionario(funcionarioRequestDTO.getNumeroTelefoneFuncionario())
                .enderecoFuncionario(funcionarioRequestDTO.getEnderecoFuncionario())
                .build();
    }

    @Override
    public Map<Long, FuncionarioEntity> getFuncionarios() {
        return null;
    }

    @Override
    public Map<Long, FuncionarioEntity> getFuncionarioById() {
        return null;
    }

    @Override
    public Map<Long, FuncionarioEntity> updateFuncionarioById() {
        return null;
    }

    @Override
    public Map<Long, FuncionarioEntity> deleteFuncionarioById() {
        return null;
    }
}