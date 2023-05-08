package com.sistema.de.gestao.de.funcionarios.gestao.controller;

import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioRequestDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.dto.FuncionarioResponseDTO;
import com.sistema.de.gestao.de.funcionarios.gestao.entity.FuncionarioEntity;
import com.sistema.de.gestao.de.funcionarios.gestao.service.FuncionarioService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Map;
import java.util.Set;

@RequestMapping(value = "/v1")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    private Map<Long, FuncionarioEntity> funcionarios;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário cadastrado com sucesso", content = @Content),
            @ApiResponse(responseCode = "400", description = "Dados preenchidos incorretamente", content = @Content),
            @ApiResponse(responseCode = "409", description = "Funcionário já cadastrado", content = @Content)
    })
    @PostMapping("/insertFuncionario")
    public ResponseEntity<String> insertFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarios = funcionarioService.insertFuncionario(funcionarios, funcionarioRequestDTO);
        return ResponseEntity.ok("Usuário adicionado com sucesso");
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados do funcionário retornados com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado", content = @Content)
    })
    @GetMapping("/getFuncionarioById/{id}")
    public ResponseEntity<FuncionarioResponseDTO> getFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.getFuncionarioById(funcionarios, id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso", content = @Content),
            @ApiResponse(responseCode = "204", description = "Nenhum funcionário cadastrado", content = @Content)
    })
    @GetMapping("/getFuncionarios")
    public ResponseEntity<Set<Map.Entry<Long, FuncionarioEntity>>> getFuncionarios() {
        return ResponseEntity.ok(funcionarioService.getFuncionarios(funcionarios));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro alterado com sucesso!", content = @Content),
            @ApiResponse(responseCode = "400", description = "Dados preenchidos incorretamente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado", content = @Content)
    })
    @PutMapping("/updateFuncionario")
    public ResponseEntity<String> updateFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO) {
        funcionarios = funcionarioService.updateFuncionarioById(funcionarios, funcionarioRequestDTO);
        return ResponseEntity.ok("Registro alterado com sucesso!");
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro deletado com sucesso!", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado", content = @Content)
    })
    @DeleteMapping("/deleteFuncionario/{id}")
    public ResponseEntity<String> deleteFuncionarioById(@PathVariable Long id) {
        funcionarios = funcionarioService.deleteFuncionarioById(funcionarios, id);
        return ResponseEntity.ok("Funcionario deletado com sucesso!");
    }

}
