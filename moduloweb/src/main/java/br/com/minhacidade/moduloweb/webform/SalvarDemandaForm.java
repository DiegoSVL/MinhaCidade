package br.com.minhacidade.moduloweb.webform;

import br.com.minhacidade.moduloweb.model.Endereco;
import br.com.minhacidade.moduloweb.model.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalvarDemandaForm {
    private String titulo;
    private String descricao;
    private String logradouro;
    private String numero;
    private String bairro;
}
