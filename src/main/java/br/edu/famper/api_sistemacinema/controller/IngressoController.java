package br.edu.famper.api_sistemacinema.controller;

import br.edu.famper.api_sistemacinema.dto.IngressoDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.Ingresso;
import br.edu.famper.api_sistemacinema.Service.IngressoService;
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
@RequestMapping("/api/siscinema/ingresso")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Ingresso",
        description = "Operation for ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all ingressos from DB",
            description = "Fetches all ingressos from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<IngressoDto> getAllIngressos() {
        log.info("Buscando todos os ingressoe");
        return ingressoService.getAllIngresso();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one ingresso from DB",
            description = "Fetches one ingresso from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<IngressoDto> getIngressoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando ingressoe por id: {}", id);
        return ResponseEntity.ok().body(ingressoService.getIngressoById(id));
    }

    @PostMapping
    @Operation(summary = "Save ingresso",
            description = "Save a ingresso in database"
    )
    public Ingresso createIngresso(@RequestBody IngressoDto ingressoeDto) throws ResourceNotFoundException {
        log.info("Cadastro ingresso: {}", ingressoeDto);
        return ingressoService.saveIngresso(ingressoeDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update ingresso",
            description = "Update a ingresso in database"
    )
    public ResponseEntity<IngressoDto> updateIngresso(@PathVariable(name = "id") Long id, @RequestBody IngressoDto ingressoeDto) throws ResourceNotFoundException {
        log.info("Atualizando ingressoe: {}", ingressoeDto);
        return ResponseEntity.ok(ingressoService.editIngresso(id, ingressoeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove ingresso",
            description = "Remove a ingresso in database"
    )
    public Map<String, Boolean> deleteIngresso(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando ingressoe: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", ingressoService.deleteIngresso(id));
        return response;
    }


}