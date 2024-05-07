package br.com.example.api.cadastro.controller;


import br.com.example.api.cadastro.dto.PessoaInDto;
import br.com.example.api.cadastro.dto.PessoaOutDto;
import br.com.example.api.cadastro.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
@Tag(description = "API de Pessoas", name = "Pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public List<PessoaOutDto> findAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public PessoaOutDto findById(UUID id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public void save(PessoaInDto pessoaInDto) {
        pessoaService.save(pessoaInDto);
    }

    @PutMapping("/update")
    public void update(PessoaInDto pessoaInDto) {
        pessoaService.update(pessoaInDto);
    }

    @DeleteMapping("/{id}")
    public void delete(UUID idPessoa) {
        pessoaService.delete(idPessoa);
    }

}
