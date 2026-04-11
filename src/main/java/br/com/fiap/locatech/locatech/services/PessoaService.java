package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.repositories.PessoaRepository;
import br.com.fiap.locatech.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoas (int page, int size) {
        int offset = (page - 1) * size;
        return this.pessoaRepository.findAll(size, offset);
    }

    public Pessoa findPessoaById(long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada."));
    }

    public void savePessoa(Pessoa pessoa) {
        var save = this.pessoaRepository.save(pessoa);
        Assert.state(save == 1, "Erro ao salvar pessoa " + pessoa.getNome());
    }

    public void updatePessoa(Pessoa pessoa, Long id) {
        var update = this.pessoaRepository.update(pessoa, id);
        if (update == 0 ) {
            throw new ResourceNotFoundException("Pessoa não encontrada");
        }
    }

    public void delete(Long id) {
        var delete = this.pessoaRepository.delete(id);
        if (delete == 0 ) {
            throw new ResourceNotFoundException("Pessoa não encontrada");
        }
    }
}
