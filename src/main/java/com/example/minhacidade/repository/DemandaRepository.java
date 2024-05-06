package com.example.minhacidade.repository;

import com.example.minhacidade.model.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
