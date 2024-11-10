package br.edu.famper.api_sistemacinema.controller;

import br.edu.famper.api_sistemacinema.dto.SalacinemaDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.SalaCinema;
import br.edu.famper.api_sistemacinema.Service.SalacinemaService;
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
@RequestMapping("/api/siscinema/salacinema")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Salacinema",
        description = "Operation for salacinema")
public class SalacinemaController {

    private final SalacinemaService salacinemaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all salacinemas from DB",
            description = "Fetches all salacinema from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<SalacinemaDto> getAllSalacinemas() {
        log.info("Buscando todos os salacinemae");
        return salacinemaService.getAllSalacinema();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one salacinema from DB",
            description = "Fetches one salacinema from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<SalacinemaDto> getSalacinemaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando salacinema por id: {}", id);
        return ResponseEntity.ok().body(salacinemaService.getSalacinemaById(id));
    }

    @PostMapping
    @Operation(summary = "Save salacinema",
            description = "Save a salacinema in database"
    )
    public SalaCinema createSalacinema(@RequestBody SalacinemaDto salacinemaeDto) throws ResourceNotFoundException {
        log.info("Cadastro salacinema: {}", salacinemaeDto);
        return salacinemaService.saveSalacinema(salacinemaeDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update salacinema",
            description = "Update a salacinema in database"
    )
    public ResponseEntity<SalacinemaDto> updateSalacinema(@PathVariable(name = "id") Long id, @RequestBody SalacinemaDto salacinemaeDto) throws ResourceNotFoundException {
        log.info("Atualizando salacinemae: {}", salacinemaeDto);
        return ResponseEntity.ok(salacinemaService.editSalacinema(id, salacinemaeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove salacinema",
            description = "Remove a salacinema in database"
    )
    public Map<String, Boolean> deleteSalacinema(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando salacinemae: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", salacinemaService.deleteSalacinema(id));
        return response;
    }


}