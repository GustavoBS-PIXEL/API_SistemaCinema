package br.edu.famper.api_sistemacinema.Service;

import br.edu.famper.api_sistemacinema.dto.SessaoDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.Filme;
import br.edu.famper.api_sistemacinema.model.SalaCinema;
import br.edu.famper.api_sistemacinema.model.Sessao;
import br.edu.famper.api_sistemacinema.repository.FilmeRepository;
import br.edu.famper.api_sistemacinema.repository.SalacinemaRepository;
import br.edu.famper.api_sistemacinema.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SalacinemaRepository salaCinemaRepository;

    public List<SessaoDto> getAllSessao(){
        return sessaoRepository
                .findAll()
                .stream()
                .map(sessao -> SessaoDto
                        .builder()
                        .filme(sessao.getFilme())
                        .salaCinema(sessao.getSala())
                        .data(sessao.getData())
                        .hora(sessao.getHora())
                        .build()
                )
                .toList();
    }

    // buscar um sessao
    public SessaoDto getSessaoById(Long id){
        Sessao ses = sessaoRepository.findById(id).orElseThrow();
        return new SessaoDto()
                .builder()
                .filme(ses.getFilme())
                .salaCinema(ses.getSala())
                .data(ses.getData())
                .hora(ses.getHora())
                .build();
    }

    // inserir um sessao
    public Sessao saveSessao(SessaoDto sessaoDto) throws ResourceNotFoundException {
        Sessao sessao = new Sessao();

        Filme filme = filmeRepository.findById(sessaoDto.getFilme().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id: " + sessaoDto.getFilme().getId()));

        SalaCinema sala = salaCinemaRepository.findById(sessaoDto.getSalaCinema().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada com id: " + sessaoDto.getSalaCinema().getId()));

        sessao.setFilme(filme);
        sessao.setSala(sala);
        sessao.setData(sessaoDto.getData());
        sessao.setHora(sessaoDto.getHora());

        return sessaoRepository.save(sessao);
    }

    // editar um sessao
    public SessaoDto editSessao(Long id, SessaoDto sessaoDto){
        Sessao sessao = sessaoRepository.findById(id).orElseThrow();
        sessao.setFilme(sessaoDto.getFilme());
        sessao.setSala(sessaoDto.getSalaCinema());
        sessao.setData(sessaoDto.getData());
        sessao.setHora(sessaoDto.getHora());
        Sessao sessaoEdited = sessaoRepository.save(sessao);
        return new SessaoDto()
                .builder()
                .filme(sessaoEdited.getFilme())
                .salaCinema(sessaoEdited.getSala())
                .data(sessaoEdited.getData())
                .hora(sessaoEdited.getHora())
                .build();
    }
    // apagar um sessao
    public boolean deleteSessao(Long id){
        try{
            Sessao sessao = sessaoRepository.findById(id).orElseThrow();
            sessaoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
