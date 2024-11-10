package br.edu.famper.api_sistemacinema.controller;

import br.edu.famper.api_sistemacinema.dto.SessaoDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.Sessao;
import br.edu.famper.api_sistemacinema.Service.SessaoService;
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
@RequestMapping("/api/siscinema/sessao")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Sessao",
        description = "Operation for sessao")
public class SessaoController {

    private final SessaoService sessaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all sessao from DB",
            description = "Fetches all sessao from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<SessaoDto> getAllSessaos() {
        log.info("Buscando todos os sessao");
        return sessaoService.getAllSessao();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one sessao from DB",
            description = "Fetches one sessao from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<SessaoDto> getSessaoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando sessao por id: {}", id);
        return ResponseEntity.ok().body(sessaoService.getSessaoById(id));
    }

    @PostMapping
    @Operation(summary = "Save sessao",
            description = "Save a sessao in database"
    )
    public Sessao createSessao(@RequestBody SessaoDto sessaoeDto) throws ResourceNotFoundException {
        log.info("Cadastro sessao: {}", sessaoeDto);
        return sessaoService.saveSessao(sessaoeDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update sessao",
            description = "Update a sessao in database"
    )
    public ResponseEntity<SessaoDto> updateSessao(@PathVariable(name = "id") Long id, @RequestBody SessaoDto sessaoeDto) throws ResourceNotFoundException {
        log.info("Atualizando sessaoe: {}", sessaoeDto);
        return ResponseEntity.ok(sessaoService.editSessao(id, sessaoeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove sessao",
            description = "Remove a sessao in database"
    )
    public Map<String, Boolean> deleteSessao(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando sessao: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", sessaoService.deleteSessao(id));
        return response;
    }


}