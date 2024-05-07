package br.com.example.api.cadastro.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PessoaInDto {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

}
