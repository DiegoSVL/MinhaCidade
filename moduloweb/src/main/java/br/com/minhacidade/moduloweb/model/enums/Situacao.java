package br.com.minhacidade.moduloweb.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Situacao {
    AGUARDANDO_APROVACAO("AGA"),
    CANCELADA("CAN"),
    APROVADA("APR"),
    ATENDIDA("ATN");

    private String codigo;
    private Situacao(String codigo){
        this.codigo = codigo;
    }

    private String getCodigo(){
        return this.codigo;
    }

    public Optional<Situacao> getSituacaoByCodigo(String codigo){
        return Arrays.stream(Situacao.values()).filter(s->s.getCodigo().equals(codigo)).findFirst();
    }
}
