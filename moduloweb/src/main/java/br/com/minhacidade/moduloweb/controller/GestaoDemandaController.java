package br.com.minhacidade.moduloweb.controller;

import br.com.minhacidade.moduloweb.model.Demanda;
import br.com.minhacidade.moduloweb.model.Endereco;
import br.com.minhacidade.moduloweb.service.DemandaService;
import br.com.minhacidade.moduloweb.webform.SalvarDemandaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GestaoDemandaController {
    @Autowired
    private DemandaService service;
    @GetMapping("/admin/aprovarDemandas")
    public String aprovarDemandas(Model model) {
        return consultarDemanda(model);
    }

    private String consultarDemanda(Model model) {
        List<Demanda> demandas = service.getDemandas();

        if (demandas != null) {
            model.addAttribute("demandas", demandas);
        }

        return "aprovarDemandas";
    }
}
