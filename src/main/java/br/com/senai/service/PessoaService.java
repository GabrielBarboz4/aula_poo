package br.com.senai.service;

import br.com.senai.entity.Pessoa;
import br.com.senai.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        return pessoaRepository.buscarPessoaPorNome(nomePessoa);
    }
    public void excluirPessoa (Long id) {
        pessoaRepository.deleteById(id);
    }
}