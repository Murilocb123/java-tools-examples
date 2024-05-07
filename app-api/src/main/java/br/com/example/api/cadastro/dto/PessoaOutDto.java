package br.com.example.api.cadastro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PessoaOutDto {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
