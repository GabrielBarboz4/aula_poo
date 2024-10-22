package br.com.senai.repository;

import br.com.senai.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p WHERE LOWER(p.nome) = LOWER(?1)")
    Optional<Pessoa> buscarPessoaPorNome(String nomePessoa);
}
