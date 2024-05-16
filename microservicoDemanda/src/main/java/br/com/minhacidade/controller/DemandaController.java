package br.com.minhacidade.controller;

import br.com.minhacidade.model.Demanda;
import br.com.minhacidade.service.DemandaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class DemandaController {
    @Autowired
    DemandaService service;

    @GetMapping("/demandas/{id}")
    public ResponseEntity<Demanda> find(@PathVariable("id") Long id) {
        log.info("GET : /demandas/{}", id);
        long initialMillis = System.currentTimeMillis();
        Optional<Demanda> demanda = service.findById(id);
        log.info("Demanda de id {} foi consultada em {}ms", id, getTimeMillis(initialMillis));
        log.info("GET : /demandas/{} Response: {}", id, demanda);
        return demanda
                .map(value -> ResponseEntity.status(HttpStatus.OK).body((value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/demandas")
    public ResponseEntity<List<Demanda>> list() {
        log.info("GET : /demandas");
        long initialMillis = System.currentTimeMillis();
        List<Demanda> demandas = service.findAll();
        log.info("Demandas listadas em {}ms", id, getTimeMillis(initialMillis));
        log.info("GET : /demandas Response: {}", demandas);
        return ResponseEntity.status(HttpStatus.OK).body(demandas);
    }

    @PostMapping("/demandas")
    public ResponseEntity<Demanda> create(@RequestBody Demanda demanda) {
        log.info("POST : /demandas");
        long initialMillis = System.currentTimeMillis();
        Demanda demandaSalva = service.create(demanda);
        log.info("Demanda de id {} foi criada em {}ms", demandaSalva.getId(), getTimeMillis(initialMillis));
        log.info("POST : /demandas Response: {}", demandaSalva);
        return ResponseEntity.status(HttpStatus.OK).body(demandaSalva);
    }

    @PutMapping("/demandas/{id}")
    public ResponseEntity<Demanda> update(@PathVariable("id") Long id, @RequestBody Demanda demanda) {
        log.info("POST : /demandas/{}", id);
        long initialMillis = System.currentTimeMillis();
        demanda.setId(id);
        Demanda demandaSalva = service.create(demanda);
        log.info("Demanda de id {} foi atualizada em {}ms", id, getTimeMillis(initialMillis));
        log.info("POST : //demandas/{} Response: {}", id, demandaSalva);
        return ResponseEntity.status(HttpStatus.OK).body(demandaSalva);
    }

    @DeleteMapping("/demandas/{id}")
    public ResponseEntity<Demanda> delete(@PathVariable("id") Long id) {
        log.info("DELETE : /demandas/{}", id);
        long initialMillis = System.currentTimeMillis();
        service.delete(id);
        log.info("Demanda de id {} foi excluída em {}ms", id, getTimeMillis(initialMillis));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private static long getTimeMillis(long initialMillis) {
        return System.currentTimeMillis() - initialMillis;
    }
}
