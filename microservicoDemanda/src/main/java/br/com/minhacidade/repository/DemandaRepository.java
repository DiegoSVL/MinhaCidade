package br.com.minhacidade.repository;

import br.com.minhacidade.model.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
