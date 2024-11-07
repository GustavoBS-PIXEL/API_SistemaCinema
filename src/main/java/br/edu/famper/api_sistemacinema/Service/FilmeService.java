package br.edu.famper.api_sistemacinema.Service;

import br.edu.famper.api_sistemacinema.dto.FilmeDto;
import br.edu.famper.api_sistemacinema.model.Filme;
import br.edu.famper.api_sistemacinema.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeDto> getAllFilme(){
        return filmeRepository
                .findAll()
                .stream()
                .map(filme -> FilmeDto
                        .builder()
                        .nome(filme.getNome())
                        .descricao(filme.getDescricao())
                        .genero(filme.getGenero())
                        .classificacaoetaria(filme.getClassificacaoetaria())
                        .nota(filme.getNota())
                        .data_lanc(filme.getDatalancamento())
                        .build()
                )
                .toList();
    }

    // buscar um filme
    public FilmeDto getFilmeById(Long id){
        Filme fil = filmeRepository.findById(id).orElseThrow();
        return new FilmeDto()
                .builder()
                .nome(fil.getNome())
                .descricao(fil.getDescricao())
                .genero(fil.getGenero())
                .classificacaoetaria(fil.getClassificacaoetaria())
                .nota(fil.getNota())
                .data_lanc(fil.getDatalancamento())
                .build();
    }

    // inserir um filme
    public Filme saveFilme(FilmeDto filmeDto){
        Filme filme = new Filme();
        filme.setNome(filmeDto.getNome());
        filme.setDescricao(filmeDto.getDescricao());
        filme.setGenero(filmeDto.getGenero());
        filme.setClassificacaoetaria(filmeDto.getClassificacaoetaria());
        filme.setNota(filmeDto.getNota());
        filme.setDatalancamento(filmeDto.getData_lanc());
        return filmeRepository.save(filme);
    }

    // editar um filme
    public FilmeDto editFilme(Long id, FilmeDto filmeDto){
        Filme filme = filmeRepository.findById(id).orElseThrow();
        filme.setNome(filmeDto.getNome());
        filme.setDescricao(filmeDto.getDescricao());
        filme.setGenero(filmeDto.getGenero());
        filme.setClassificacaoetaria(filmeDto.getClassificacaoetaria());
        filme.setNota(filmeDto.getNota());
        filme.setDatalancamento(filmeDto.getData_lanc());
        Filme filmeEdited = filmeRepository.save(filme);
        return new FilmeDto()
                .builder()
                .nome(filmeEdited.getNome())
                .descricao(filmeEdited.getDescricao())
                .genero(filmeEdited.getGenero())
                .classificacaoetaria(filmeEdited.getClassificacaoetaria())
                .nota(filmeEdited.getNota())
                .data_lanc(filmeEdited.getDatalancamento())
                .build();
    }

    // apagar um filme
    public boolean deleteFilme(Long id){
        try{
            Filme filme = filmeRepository.findById(id).orElseThrow();
            filmeRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}