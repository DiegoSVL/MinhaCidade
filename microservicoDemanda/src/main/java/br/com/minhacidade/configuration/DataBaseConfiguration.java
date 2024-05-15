package br.com.minhacidade.configuration;

import br.com.minhacidade.model.Demanda;
import br.com.minhacidade.model.Endereco;
import br.com.minhacidade.service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class DataBaseConfiguration {

    @Autowired
    DemandaService service;
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        service.create(Demanda.builder().titulo("Buraco na rua").descricao("Tem um buraco no meio da rua que pode causar um acidente grave").endereco(Endereco.builder().bairro("Ipanema").logradouro("Rua Vinicius de Moraes").numero("110").build()).build());
        service.create(Demanda.builder().titulo("Falta de iluminação").descricao("As luzes dos postes estão quebradas deixando o local mal iluminado e perigoso").endereco(Endereco.builder().bairro("Leblon").logradouro("Avenida Delfim Moreira").numero("1234").build()).build());
        service.create(Demanda.builder().titulo("Vazamento de água").descricao("Há um vazamento de água na calçada que está desperdiçando recursos e causando alagamento").endereco(Endereco.builder().bairro("Barra da Tijuca").logradouro("Avenida das Américas").numero("2000").build()).build());
        service.create(Demanda.builder().titulo("Calçada danificada").descricao("A calçada está quebrada e representa um risco de tropeço para os pedestres").endereco(Endereco.builder().bairro("Botafogo").logradouro("Rua Voluntários da Pátria").numero("400").build()).build());
        service.create(Demanda.builder().titulo("Árvore caída").descricao("Uma árvore caiu bloqueando a passagem de veículos e pedestres").endereco(Endereco.builder().bairro("Santa Teresa").logradouro("Rua Almirante Alexandrino").numero("501").build()).build());
        service.create(Demanda.builder().titulo("Bueiro entupido").descricao("O bueiro está entupido e causando alagamento na rua durante as chuvas").endereco(Endereco.builder().bairro("Laranjeiras").logradouro("Rua das Laranjeiras").numero("1").build()).build());
        service.create(Demanda.builder().titulo("Pichação em prédio público").descricao("Um prédio público foi pichado, comprometendo a estética e o patrimônio").endereco(Endereco.builder().bairro("Jardim Botânico").logradouro("Rua Jardim Botânico").numero("1008").build()).build());
        service.create(Demanda.builder().titulo("Semáforo com defeito").descricao("O semáforo está com defeito e causando confusão no trânsito").endereco(Endereco.builder().bairro("Gávea").logradouro("Rua Marquês de São Vicente").numero("225").build()).build());
        service.create(Demanda.builder().titulo("Falta de coleta de lixo").descricao("O lixo não está sendo coletado regularmente, causando acúmulo e mau cheiro").endereco(Endereco.builder().bairro("Flamengo").logradouro("Avenida Rui Barbosa").numero("762").build()).build());
        service.create(Demanda.builder().titulo("Estacionamento irregular").descricao("Veículos estão estacionando irregularmente em local proibido").endereco(Endereco.builder().bairro("Tijuca").logradouro("Rua Conde de Bonfim").numero("358").build()).build());
        service.create(Demanda.builder().titulo("Infiltração em residência").descricao("Uma residência está com problemas de infiltração, causando danos à estrutura").endereco(Endereco.builder().bairro("Lapa").logradouro("Rua do Lavradio").numero("71").build()).build());
        service.create(Demanda.builder().titulo("Roubo de placas de rua").descricao("Placas de rua foram roubadas, dificultando a orientação dos moradores e visitantes").endereco(Endereco.builder().bairro("Catete").logradouro("Rua do Catete").numero("153").build()).build());
        service.create(Demanda.builder().titulo("Falta de sinalização de trânsito").descricao("Falta de sinalização em cruzamento perigoso está causando acidentes").endereco(Endereco.builder().bairro("Glória").logradouro("Rua da Glória").numero("98").build()).build());
        service.create(Demanda.builder().titulo("Escola com infestação de pragas").descricao("Uma escola está com infestação de pragas, comprometendo a saúde dos alunos").endereco(Endereco.builder().bairro("Maracanã").logradouro("Rua Professor Eurico Rabelo").numero("30").build()).build());
        service.create(Demanda.builder().titulo("Buraco em ciclovia").descricao("Um buraco na ciclovia está colocando em risco os ciclistas que passam pelo local").endereco(Endereco.builder().bairro("Centro").logradouro("Avenida Rio Branco").numero("1").build()).build());
        service.create(Demanda.builder().titulo("Falta de acessibilidade em calçada").descricao("A calçada não possui rampa de acessibilidade para cadeirantes").endereco(Endereco.builder().bairro("Santa Cruz").logradouro("Rua Felipe Cardoso").numero("5000").build()).build());
        service.create(Demanda.builder().titulo("Poste com fiação exposta").descricao("Um poste está com a fiação exposta, representando perigo para pedestres").endereco(Endereco.builder().bairro("Campo Grande").logradouro("Rua Campo Grande").numero("958").build()).build());
        service.create(Demanda.builder().titulo("Depósito irregular de entulho").descricao("Entulho está sendo depositado irregularmente em via pública").endereco(Endereco.builder().bairro("Rocinha").logradouro("Rua 1").numero("800").build()).build());
        service.create(Demanda.builder().titulo("Invasão de área pública").descricao("Uma área pública está sendo invadida por moradores irregulares").endereco(Endereco.builder().bairro("Jacarepaguá").logradouro("Estrada dos Três Rios").numero("2000").build()).build());
        service.create(Demanda.builder().titulo("Ponto de ônibus danificado").descricao("O ponto de ônibus está danificado, oferecendo pouco conforto aos passageiros").endereco(Endereco.builder().bairro("Barra da Tijuca").logradouro("Avenida das Américas").numero("2000").build()).build());


    }
}
