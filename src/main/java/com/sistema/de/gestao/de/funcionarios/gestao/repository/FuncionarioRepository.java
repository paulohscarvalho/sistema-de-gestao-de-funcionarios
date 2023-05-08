package com.sistema.de.gestao.de.funcionarios.gestao.repository;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioResponseDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.NenhumUsuarioCadastradoException;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioNaoEncontradoException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public class FuncionarioRepository {

    public Map<Long, FuncionarioEntity> insertFuncionario(Map<Long, FuncionarioEntity> funcionarios, FuncionarioEntity funcionarioEntity) {
        funcionarios.put(funcionarioEntity.getIdFuncionario(), funcionarioEntity);
        return funcionarios;
    }

    public FuncionarioResponseDTO getFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, Long id) {
        FuncionarioEntity funcionarioEntity;

        try {
            funcionarioEntity = funcionarios.get(id);
        } catch (Exception e) {
            throw new UsuarioNaoEncontradoException();
        }

        return FuncionarioResponseDTO
                .builder()
                .IdFuncionario(funcionarioEntity.getIdFuncionario())
                .nomeFuncionario(funcionarioEntity.getNomeFuncionario())
                .designacaoFuncionario(funcionarioEntity.getDesignacaoFuncionario())
                .salarioFuncionario(funcionarioEntity.getSalarioFuncionario())
                .numeroTelefoneFuncionario(funcionarioEntity.getNumeroTelefoneFuncionario())
                .enderecoFuncionario(funcionarioEntity.getEnderecoFuncionario())
                .build();
    }

    public Set<Map.Entry<Long, FuncionarioEntity>> getFuncionarios(Map<Long, FuncionarioEntity> funcionarios) {
        try {
            return funcionarios.entrySet();
        } catch (Exception e) {
            throw new NenhumUsuarioCadastradoException();
        }
    }

    public Map<Long, FuncionarioEntity> updateFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, FuncionarioEntity funcionarioEntity) {
        try {
            funcionarios.get(funcionarioEntity.getIdFuncionario());
            funcionarios.put(funcionarioEntity.getIdFuncionario(), funcionarioEntity);
            return funcionarios;
        } catch (Exception e) {
            throw new UsuarioNaoEncontradoException();
        }
    }

    public Map<Long, FuncionarioEntity> deleteFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, Long id) {
        try {
            funcionarios.remove(id);
            return funcionarios;
        } catch (Exception e) {
            throw new UsuarioNaoEncontradoException();
        }
    }
}
