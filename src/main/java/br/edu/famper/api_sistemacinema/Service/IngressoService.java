package br.edu.famper.api_sistemacinema.Service;

import br.edu.famper.api_sistemacinema.dto.IngressoDto;
import br.edu.famper.api_sistemacinema.model.Ingresso;
import br.edu.famper.api_sistemacinema.repository.IngressoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    public List<IngressoDto> getAllIngresso(){
        return ingressoRepository
                .findAll()
                .stream()
                .map(ingresso -> IngressoDto
                        .builder()
                        .sessao(ingresso.getSessao())
                        .cliente(ingresso.getCliente())
                        .num_cadeira(ingresso.getNum_cadeira())
                        .data_compra(ingresso.getData_compra())
                        .build()
                )
                .toList();
    }

    // buscar um ingresso
    public IngressoDto getIngressoById(Long id){
        Ingresso ing = ingressoRepository.findById(id).orElseThrow();
        return new IngressoDto()
                .builder()
                .sessao(ing.getSessao())
                .cliente(ing.getCliente())
                .num_cadeira(ing.getNum_cadeira())
                .data_compra(ing.getData_compra())
                .build();
    }

    // inserir um ingresso
    public Ingresso saveIngresso(IngressoDto ingressoDto){
        Ingresso ingresso = new Ingresso();
        ingresso.setSessao(ingressoDto.getSessao());
        ingresso.setCliente(ingressoDto.getCliente());
        ingresso.setNum_cadeira(ingressoDto.getNum_cadeira());
        ingresso.setData_compra(ingressoDto.getData_compra());
        return ingressoRepository.save(ingresso);
    }

    // editar um ingresso
    public IngressoDto editIngresso(Long id, IngressoDto ingressoDto){
        Ingresso ingresso = ingressoRepository.findById(id).orElseThrow();
        ingresso.setSessao(ingressoDto.getSessao());
        ingresso.setCliente(ingressoDto.getCliente());
        ingresso.setNum_cadeira(ingressoDto.getNum_cadeira());
        ingresso.setData_compra(ingressoDto.getData_compra());
        Ingresso ingressoEdited = ingressoRepository.save(ingresso);
        return new IngressoDto()
                .builder()
                .sessao(ingressoEdited.getSessao())
                .cliente(ingressoEdited.getCliente())
                .num_cadeira(ingressoEdited.getNum_cadeira())
                .data_compra(ingressoEdited.getData_compra())
                .build();
    }

    // apagar um ingresso
    public boolean deleteIngresso(Long id){
        try{
            Ingresso ingresso = ingressoRepository.findById(id).orElseThrow();
            ingressoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}