package br.com.minhacidade.model;

import br.com.minhacidade.model.enums.Situacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Demanda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Situacao situacao;
    @ManyToOne(cascade=CascadeType.ALL)
    private Endereco endereco;
}
