package br.com.minhacidade.moduloweb.controller;

import br.com.minhacidade.moduloweb.model.Demanda;
import br.com.minhacidade.moduloweb.model.Endereco;
import br.com.minhacidade.moduloweb.service.DemandaService;
import br.com.minhacidade.moduloweb.webform.SalvarDemandaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DemandaController {
    @Autowired
    private DemandaService service;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "adminIndex";
        }
        return "userIndex";
    }
    @GetMapping("/user/demandas")
    public String listarDemanda(Model model) {
        return consultarDemanda(model);
    }

    @PostMapping("/user/demandas")
    public String consultarDemanda(@ModelAttribute("Demanda") Demanda demanda, Model model) {
        return consultarDemanda(model);
    }

    @GetMapping("/user/detalharDemanda/{id}")
    public String detalharDemanda(@PathVariable("id") String id, Model model) {
        Demanda demanda = service.getDemandaById(id);

        if (demanda != null) {
            model.addAttribute("demanda", demanda);
            model.addAttribute("enderecos", demanda.getEndereco());

            return "detalharDemanda";
        } else {
            return consultarDemanda(model);
        }
    }

    @GetMapping("/user/excluirDemanda/{id}")
    public String excluirDemanda(@PathVariable("id") String id, Model model) {
        service.delete(id);
        return consultarDemanda(model);
    }

    @GetMapping("/user/preencherDemanda")
    public String preencherDemanda(@ModelAttribute("salvarDemandaForm") SalvarDemandaForm salvarDemandaForm, Model model){
        return "salvarDemanda";
    }
    @PostMapping(path = "/user/salvarDemanda")
    public String salvarDemanda(@ModelAttribute("salvarDemandaForm") SalvarDemandaForm salvarDemandaForm, Model model) {
        var demanda = Demanda.builder()
                .titulo(salvarDemandaForm.getTitulo())
                .descricao(salvarDemandaForm.getDescricao())
                .endereco(Endereco.builder()
                        .logradouro(salvarDemandaForm.getLogradouro())
                        .bairro(salvarDemandaForm.getBairro())
                        .numero(salvarDemandaForm.getNumero())
                        .build())
                .build();
        var demandaSalva = service.create(demanda);

        if (demandaSalva != null) {
            model.addAttribute("demanda", demanda);
            model.addAttribute("enderecos", demanda.getEndereco());

            return "detalharDemanda";
        } else {
            return consultarDemanda(model);
        }
    }

    private String consultarDemanda(Model model) {
        List<Demanda> demandas = service.getDemandas();

        if (demandas != null) {
            model.addAttribute("demandas", demandas);
        }

        return "consultarDemanda";
    }
}
