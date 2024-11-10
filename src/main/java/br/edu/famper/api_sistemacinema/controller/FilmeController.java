package br.edu.famper.api_sistemacinema.controller;

import br.edu.famper.api_sistemacinema.dto.FilmeDto;
import br.edu.famper.api_sistemacinema.exception.ResourceNotFoundException;
import br.edu.famper.api_sistemacinema.model.Filme;
import br.edu.famper.api_sistemacinema.Service.FilmeService;
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
@RequestMapping("/api/siscinema/filme")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Filme",
        description = "Operation for filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all filmes from DB",
            description = "Fetches all filmes from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<FilmeDto> getAllFilmes() {
        log.info("Buscando todos os filmee");
        return filmeService.getAllFilme();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one filme from DB",
            description = "Fetches one filme from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<FilmeDto> getFilmeById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando filmee por id: {}", id);
        return ResponseEntity.ok().body(filmeService.getFilmeById(id));
    }

    @PostMapping
    @Operation(summary = "Save filme",
            description = "Save a filme in database"
    )
    public Filme createFilme(@RequestBody FilmeDto filmeeDto) throws ResourceNotFoundException {
        log.info("Cadastro filme: {}", filmeeDto);
        return filmeService.saveFilme(filmeeDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update filme",
            description = "Update a filme in database"
    )
    public ResponseEntity<FilmeDto> updateFilme(@PathVariable(name = "id") Long id, @RequestBody FilmeDto filmeeDto) throws ResourceNotFoundException {
        log.info("Atualizando filmee: {}", filmeeDto);
        return ResponseEntity.ok(filmeService.editFilme(id, filmeeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove filme",
            description = "Remove a filme in database"
    )
    public Map<String, Boolean> deleteFilme(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando filmee: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", filmeService.deleteFilme(id));
        return response;
    }


}