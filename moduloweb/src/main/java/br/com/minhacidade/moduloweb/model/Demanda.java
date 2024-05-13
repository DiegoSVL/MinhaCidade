package br.com.minhacidade.moduloweb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Demanda {
    private Long id;
    private String descricao;
    private Endereco endereco;
}
