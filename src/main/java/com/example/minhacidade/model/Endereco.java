package com.example.minhacidade.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@Entity
public class Endereco {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
}
