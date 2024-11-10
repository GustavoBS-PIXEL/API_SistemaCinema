package br.edu.famper.api_sistemacinema.controller;

import br.edu.famper.api_sistemacinema.dto.ClienteDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.Cliente;
import br.edu.famper.api_sistemacinema.Service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/siscinema/cliente")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cliente",
        description = "Operation for clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all clientes from DB",
            description = "Fetches all clientes from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ClienteDto> getAllClientes() {
        log.info("Buscando todos os clientee");
        return clienteService.getAllCliente();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one cliente from DB",
            description = "Fetches one cliente from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando clientee por id: {}", id);
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    @PostMapping
    @Operation(summary = "Save cliente",
            description = "Save a cliente in database"
    )
    public Cliente createCliente(@RequestBody ClienteDto clienteeDto) throws ResourceNotFoundException {
        log.info("Cadastro cliente: {}", clienteeDto);
        return clienteService.saveCliente(clienteeDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update cliente",
            description = "Update a cliente in database"
    )
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable(name = "id") Long id, @RequestBody ClienteDto clienteeDto) throws ResourceNotFoundException {
        log.info("Atualizando clientee: {}", clienteeDto);
        return ResponseEntity.ok(clienteService.editCliente(id, clienteeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cliente",
            description = "Remove a cliente in database"
    )
    public Map<String, Boolean> deleteCliente(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando clientee: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", clienteService.deleteCliente(id));
        return response;
    }


}