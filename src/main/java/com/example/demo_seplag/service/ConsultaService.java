package com.example.demo_seplag.service;

import com.example.demo_seplag.dto.ServidorEfetivoDTO;
import com.example.demo_seplag.entity.FotoPessoa;
import com.example.demo_seplag.entity.Lotacao;
import com.example.demo_seplag.entity.Pessoa;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.FotoPessoaRepository;
import com.example.demo_seplag.repository.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    @Autowired
    private FotoService fotoService;

    public List<ServidorEfetivoDTO> getServidoresPorUnidade(Long unidadeId) {
        List<Lotacao> lotacoes = lotacaoRepository.findByUnidadeId(unidadeId);
        if (lotacoes.isEmpty()) {
            throw new NotFoundException("Nenhum servidor encontrado para a unidade " + unidadeId);
        }
        return lotacoes.stream().map(l -> {
            Pessoa p = l.getServidorEfetivo().getPessoa();
            String nome = p.getNome();
            int idade = Period.between(p.getDataNascimento(), LocalDate.now()).getYears();
            String unidadeNome = l.getUnidade().getUnidNome();
            // Busca a foto associada à pessoa, se existir
            Optional<FotoPessoa> fotoOpt = fotoPessoaRepository.findAll().stream()
                    .filter(f -> f.getPesId().equals(p.getId()))
                    .findFirst();
            String fotoUrl = fotoOpt.map(f -> fotoService.getFotoUrlTemporario(f.getFpHash()))
                    .orElse(null);
            return new ServidorEfetivoDTO(nome, idade, unidadeNome, fotoUrl);
        }).collect(Collectors.toList());
    }
}
