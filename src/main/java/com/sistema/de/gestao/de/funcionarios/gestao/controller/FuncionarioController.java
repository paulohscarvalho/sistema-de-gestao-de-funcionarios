package com.sistema.de.gestao.de.funcionarios.gestao.controller;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;
    private Map<Long, FuncionarioEntity> funcionarios;

    @PostMapping("/insertFuncionario")
    public ResponseEntity<String> insertFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarios = funcionarioService.insertFuncionario(funcionarios, funcionarioRequestDTO);
        return ResponseEntity.ok("Usuário adicionado com sucesso");
    }

}
