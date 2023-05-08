package com.sistema.de.gestao.de.funcionarios.gestao.controller;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioResponseDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

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

    @GetMapping("/getFuncionarioById/{id}")
    public ResponseEntity<FuncionarioResponseDTO> getFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.getFuncionarioById(funcionarios, id));
    }

    @GetMapping("/getFuncionarios")
    public ResponseEntity<Set<Map.Entry<Long, FuncionarioEntity>>> getFuncionarios() {
        return ResponseEntity.ok(funcionarioService.getFuncionarios(funcionarios));
    }

    @PostMapping("/updateFuncionario")
    public ResponseEntity<String> updateFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarios = funcionarioService.updateFuncionarioById(funcionarios, funcionarioRequestDTO);
        return ResponseEntity.ok("Registro alterado com sucesso!");
    }


}
