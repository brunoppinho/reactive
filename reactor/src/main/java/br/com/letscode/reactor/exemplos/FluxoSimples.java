package br.com.letscode.reactor.exemplos;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FluxoSimples {

    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();

        log.info("Criando o fluxo");
        Flux<Integer> fluxo = Flux.just(2, 4, 6, 8, 10);

        log.info("Avisando que toda operação deverá ser logada");
        log.info("Adicionando um subscribe no fluxo que vai adicionar os elementos a uma lista");
        log.info("O fluxo só irá começar a fluir depois que associamos um subscribe a ele");
        fluxo.log().subscribe(elementos::add);

        log.info(String.valueOf(elementos.size()));
    }
}
