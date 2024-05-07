package br.com.example.model.appmodel.cadastro.repository;

import br.com.example.model.appmodel.cadastro.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
