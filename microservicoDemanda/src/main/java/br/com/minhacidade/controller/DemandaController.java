package br.com.minhacidade.controller;

import br.com.minhacidade.service.DemandaService;
import br.com.minhacidade.model.Demanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DemandaController {
    @Autowired
    DemandaService service;

    @GetMapping("/demandas/{id}")
    public ResponseEntity<Demanda> find(@PathVariable("id") Long id) {
        Optional<Demanda> demanda = service.findById(id);
        return demanda
                .map(value -> ResponseEntity.status(HttpStatus.OK).body((value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/demandas")
    public ResponseEntity<String> list() {
        List<Demanda> demandas = service.findAll();
        StringBuilder retornoSB = new StringBuilder();
        demandas.stream().forEach(a -> retornoSB.append(a.toString()).append("\r\n"));
        return ResponseEntity.status(HttpStatus.OK).body(retornoSB.toString());
    }

    @PostMapping("/demandas")
    public ResponseEntity<Demanda> save(@RequestBody Demanda demanda) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.save(demanda));
    }

    @PutMapping("/demandas/{id}")
    public ResponseEntity<Demanda> update(@PathVariable("id") Long id, @RequestBody Demanda demanda) {
        demanda.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(demanda));
    }

    @DeleteMapping("/demandas/{id}")
    public ResponseEntity<Demanda> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
