package br.com.minhacidade.moduloweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
}
