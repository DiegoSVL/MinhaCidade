package com.example.minhacidade.service;

import com.example.minhacidade.model.Demanda;
import com.example.minhacidade.repository.DemandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandaService {
    @Autowired
    private DemandaRepository repository;

    public Optional<Demanda> findById(Long id) {
        return repository.findById(id);
    }

    public List<Demanda> findAll() {
        return repository.findAll();
    }

    public Demanda save(Demanda demanda) {
        return repository.save(demanda);
    }

    public void delete(Long id) {
        Optional<Demanda> demanda = repository.findById(id);
        demanda.ifPresent(repository::delete);
    }
}
