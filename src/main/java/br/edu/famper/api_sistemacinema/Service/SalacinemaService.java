package br.edu.famper.api_sistemacinema.Service;

import br.edu.famper.api_sistemacinema.dto.SalacinemaDto;
import br.edu.famper.api_sistemacinema.model.SalaCinema;
import br.edu.famper.api_sistemacinema.repository.SalacinemaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalacinemaService {

    @Autowired
    private SalacinemaRepository salacinemaRepository;

    public List<SalacinemaDto> getAllSalacinema(){
        return salacinemaRepository
                .findAll()
                .stream()
                .map(salacinema -> SalacinemaDto
                        .builder()
                        .nome(salacinema.getNome())
                        .tamanho(salacinema.getTamanho())
                        .num_cadeiras(salacinema.getNum_cadeiras())
                        .build()
                )
                .toList();
    }

    // buscar um salacinema
    public SalacinemaDto getSalacinemaById(Long id){
        SalaCinema sal = salacinemaRepository.findById(id).orElseThrow();
        return new SalacinemaDto()
                .builder()
                .nome(sal.getNome())
                .tamanho(sal.getTamanho())
                .num_cadeiras(sal.getNum_cadeiras())
                .build();
    }

    // inserir um salacinema
    public SalaCinema saveSalacinema(SalacinemaDto salacinemaDto){
        SalaCinema salacinema = new SalaCinema();
        salacinema.setNome(salacinemaDto.getNome());
        salacinema.setTamanho(salacinemaDto.getTamanho());
        salacinema.setNum_cadeiras(salacinemaDto.getNum_cadeiras());
        return salacinemaRepository.save(salacinema);
    }

    // editar um salacinema
    public SalacinemaDto editSalacinema(Long id, SalacinemaDto salacinemaDto){
        SalaCinema salacinema = salacinemaRepository.findById(id).orElseThrow();
        salacinema.setNome(salacinemaDto.getNome());
        salacinema.setTamanho(salacinemaDto.getTamanho());
        salacinema.setNum_cadeiras(salacinemaDto.getNum_cadeiras());
        SalaCinema salacinemaEdited = salacinemaRepository.save(salacinema);
        return new SalacinemaDto()
                .builder()
                .nome(salacinemaEdited.getNome())
                .tamanho(salacinemaEdited.getTamanho())
                .num_cadeiras(salacinemaEdited.getNum_cadeiras())
                .build();
    }
    // apagar um salacinema
    public boolean deleteSalacinema(Long id){
        try{
            SalaCinema salacinema = salacinemaRepository.findById(id).orElseThrow();
            salacinemaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}