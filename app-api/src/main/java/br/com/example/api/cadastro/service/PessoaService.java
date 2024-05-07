package br.com.example.api.cadastro.service;

import br.com.example.api.cadastro.dto.PessoaInDto;
import br.com.example.api.cadastro.dto.PessoaOutDto;
import br.com.example.api.cadastro.dto.mapper.PessoaMapper;
import br.com.example.model.appmodel.cadastro.entity.Pessoa;
import br.com.example.model.appmodel.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public void save(PessoaInDto pessoaInDto) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaInDto,false);
        pessoaRepository.save(pessoa);
    }

    public void update(PessoaInDto pessoaInDto) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaInDto, true);
        pessoaRepository.save(pessoa);
    }

    public void delete(UUID idPessoa) {;
        pessoaRepository.delete(pessoaRepository.getReferenceById(idPessoa));
    }

    public List<PessoaOutDto> findAll() {
        return pessoaRepository.findAll().stream()
                .map(pessoaMapper::toDto)
                .collect(Collectors.toList());
    }

    public PessoaOutDto findById(UUID id) {
        return pessoaMapper.toDto(pessoaRepository.findById(id).orElseThrow());
    }

}
