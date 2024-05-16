package br.com.minhacidade.moduloweb.service;

import br.com.minhacidade.moduloweb.model.Demanda;
import br.com.minhacidade.moduloweb.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DemandaService {

    public static final String BASE_PATH = "https://projeto-minha-cidade-60581.uk.r.appspot.com/demandas";
    @Autowired
    RestTemplate restTemplate;
    public List<Demanda> getDemandas() {
        return restTemplate.getForObject(BASE_PATH, List.class);
    }

    public Demanda getDemandaById(String id) {
        return restTemplate.getForObject(BASE_PATH+"/"+id, Demanda.class);
    }

    public Demanda create(Demanda demanda) {
        return restTemplate.postForObject(BASE_PATH, demanda, Demanda.class);
    }

    public void update(Demanda demanda) {
        restTemplate.put(BASE_PATH+"/"+demanda.getId(), demanda);
    }

    public void delete(String id) {
        restTemplate.delete(BASE_PATH+"/"+id);
    }
}
