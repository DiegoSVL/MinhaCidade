package br.com.minhacidade.moduloweb.model;

import br.com.minhacidade.moduloweb.model.enums.Situacao;
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
    private String titulo;
    private String descricao;
    private Situacao situacao;
    private Endereco endereco;
}
