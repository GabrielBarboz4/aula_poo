package br.com.senai.service;

import br.com.senai.entity.Pessoa;
import br.com.senai.exception.EntidadeException;
import br.com.senai.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa (Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listaPessoa() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorID (Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeException("Cadastro de pessoa não encontrado"));
        return pessoa;
    }

    public Optional<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        return pessoaRepository.buscarPessoaPorNome(nomePessoa);
    }
    public void excluirPessoa (Long id) {
        pessoaRepository.deleteById(id);
    }
}