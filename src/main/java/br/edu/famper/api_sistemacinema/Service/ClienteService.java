package br.edu.famper.api_sistemacinema.Service;

import br.edu.famper.api_sistemacinema.dto.ClienteDto;
import br.edu.famper.api_sistemacinema.model.Cliente;
import br.edu.famper.api_sistemacinema.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> getAllCliente(){
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> ClienteDto
                        .builder()
                        .nome(cliente.getNome())
                        .cpf(cliente.getCpf())
                        .email(cliente.getEmail())
                        .telefone(cliente.getTelefone())
                        .data_nas(cliente.getData_nas())
                        .build()
                )
                .toList();
    }

    // buscar um cliente
    public ClienteDto getClienteById(Long id){
        Cliente cli = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto()
                .builder()
                .nome(cli.getNome())
                .cpf(cli.getCpf())
                .email(cli.getEmail())
                .telefone(cli.getTelefone())
                .data_nas(cli.getData_nas())
                .build();
    }

    // inserir um cliente
    public Cliente saveCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.getNome());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setData_nas(clienteDto.getData_nas());
        return clienteRepository.save(cliente);
    }
    // editar um cliente
    public ClienteDto editCliente(Long id, ClienteDto clienteDto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteDto.getNome());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setData_nas(clienteDto.getData_nas());
        Cliente clienteEdited = clienteRepository.save(cliente);
        return new ClienteDto()
                .builder()
                .nome(clienteEdited.getNome())
                .cpf(clienteEdited.getCpf())
                .email(clienteEdited.getEmail())
                .telefone(clienteEdited.getTelefone())
                .data_nas(clienteEdited.getData_nas())
                .build();
    }
    // apagar um cliente
    public boolean deleteCliente(Long id){
        try{
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}