package com.projeto.portalestagio.portal_estagios_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.projeto.portalestagio.portal_estagios_api.model.Empresa;
import com.projeto.portalestagio.portal_estagios_api.repository.EmpresaRepository;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Empresa cadastrar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }
}
