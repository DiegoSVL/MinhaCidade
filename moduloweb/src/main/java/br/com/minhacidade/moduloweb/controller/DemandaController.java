package br.com.minhacidade.moduloweb.controller;

import br.com.minhacidade.moduloweb.model.Demanda;
import br.com.minhacidade.moduloweb.model.Endereco;
import br.com.minhacidade.moduloweb.service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemandaController {
    @Autowired
    private DemandaService service;

    @GetMapping("/")
    public String index() {
        return "newIndex";
    }
    @GetMapping("/demandas")
    public String consultarDemanda(Model model) {
        return consultarDemanda("", model);
    }

    @PostMapping("/demandas")
    public String consultarDemanda(@ModelAttribute("Demanda") Demanda demanda, Model model) {
        return consultarDemanda(demanda.getDescricao(), model);
    }

    @GetMapping("/detalharDemanda/{id}")
    public String detalharDemanda(@PathVariable("id") String id, Model model) {
        Demanda demanda = service.getDemandaById(id);

        if (demanda != null) {
            model.addAttribute("demanda", demanda);

            /*List<Endereco> enderecos = service.getEnderecoByDemanda(demanda);
            model.addAttribute("enderecos", enderecos);*/
            model.addAttribute("enderecos", demanda.getEndereco());

            return "detalharDemanda";
        } else {
            return consultarDemanda("", model);
        }
    }

    @GetMapping("/excluirDemanda/{id}")
    public String excluirDemanda(@PathVariable("id") String id, Model model) {
        service.delete(id);
        return consultarDemanda("", model);
    }

    private String consultarDemanda(String descricao, Model model) {
        List<Demanda> demandas = service.getDemandas(descricao);

        if (demandas != null) {
            model.addAttribute("demandas", demandas);
        }

        return "consultarDemanda";
    }
}
