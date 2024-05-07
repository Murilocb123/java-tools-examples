package br.com.example.api.cadastro.dto.mapper;

import br.com.example.api.cadastro.dto.PessoaInDto;
import br.com.example.api.cadastro.dto.PessoaOutDto;
import br.com.example.model.appmodel.cadastro.entity.Pessoa;
import br.com.example.model.appmodel.cadastro.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    private final TypeMap<Pessoa, PessoaOutDto> entityToDtoMapper;
    private final TypeMap<PessoaInDto, Pessoa> dtoToEntityMapper;

    private final PessoaRepository pessoaRepository;

    public PessoaMapper(PessoaRepository pessoaRepository) {
        ModelMapper mapper = new ModelMapper();
        this.pessoaRepository = pessoaRepository;

        entityToDtoMapper = mapper.createTypeMap(Pessoa.class, PessoaOutDto.class)
                .addMappings(mappings -> {
                // Add custom mappings here
                });

        dtoToEntityMapper = mapper.createTypeMap(PessoaInDto.class, Pessoa.class)
                .addMappings(mappings -> {
                // Add custom mappings here
                    mappings.skip(Pessoa::setId);
                    mappings.skip(Pessoa::setCreatedAt);
                    mappings.skip(Pessoa::setUpdatedAt);
                });
    }

    public PessoaOutDto toDto(Pessoa pessoa) {
        return entityToDtoMapper.map(pessoa);
    }

    public Pessoa toEntity(PessoaInDto pessoaInDto, Boolean referenceId) {
        Pessoa pessoa = dtoToEntityMapper.map(pessoaInDto);

        //TODO: implementar uma classe util getOrElse()
        if(pessoaInDto.getId() != null && referenceId){
            pessoa.setId(pessoaRepository.getReferenceById(pessoaInDto.getId()).getId());
        }

        return pessoa;
    }


}
