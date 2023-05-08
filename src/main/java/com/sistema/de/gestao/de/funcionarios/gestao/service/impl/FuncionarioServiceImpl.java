package com.sistema.de.gestao.de.funcionarios.gestao.service.impl;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioResponseDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.NenhumUsuarioCadastradoException;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioJaAdicionadoException;
import com.sistema.de.gestao.de.funcionarios.gestao.exception.customException.UsuarioNaoEncontradoException;
import com.sistema.de.gestao.de.funcionarios.gestao.repository.FuncionarioRepository;
import com.sistema.de.gestao.de.funcionarios.gestao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

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

        funcionarios = funcionarioRepository.insertFuncionario(funcionarios, funcionarioRequestDtoToEntity(funcionarioRequestDTO));

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
    public Set<Map.Entry<Long, FuncionarioEntity>> getFuncionarios(Map<Long, FuncionarioEntity> funcionarios) {
        if (funcionarios.isEmpty()) {
            throw new NenhumUsuarioCadastradoException();
        }
        return funcionarioRepository.getFuncionarios(funcionarios);
    }

    @Override
    public FuncionarioResponseDTO getFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, Long id) {
        try {
            if (funcionarios.isEmpty()) {
                throw new UsuarioNaoEncontradoException();
            }
        } catch (Exception e) {
            throw new UsuarioNaoEncontradoException();
        }
        return funcionarioRepository.getFuncionarioById(funcionarios, id);
    }

    @Override
    public Map<Long, FuncionarioEntity> updateFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, FuncionarioRequestDTO funcionarioDTO) {
        FuncionarioEntity funcionarioEntity = funcionarioRequestDtoToEntity(funcionarioDTO);

        if (funcionarios.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return funcionarioRepository.updateFuncionarioById(funcionarios, funcionarioEntity);
    }

    @Override
    public Map<Long, FuncionarioEntity> deleteFuncionarioById(Map<Long, FuncionarioEntity> funcionarios, Long id) {
        if (funcionarios.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return funcionarioRepository.deleteFuncionarioById(funcionarios, id);
    }
}
