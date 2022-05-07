package br.com.letscode.reactor.exemplos;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CombinandoFluxos {

    public static void main(String[] args) {
        List<String> elementos = new ArrayList<>();

        Flux<Integer> fluxo1 = Flux.just(2, 4, 6, 8, 10);
        Flux<Integer> fluxo2 = Flux.just(1, 3, 5, 7, 9, 11);

        fluxo1
                .log()
                .zipWith(fluxo2,
                        (primeiro, segundo) -> String.format("Primeiro: %d, Segundo: %d", primeiro, segundo))
                .subscribe(elementos::add);

        log.info(elementos.toString());
        log.info(String.valueOf(elementos.size()));

        elementos = new ArrayList<>();
        fluxo2
                .log()
                .zipWith(fluxo1,
                        (primeiro, segundo) -> String.format("Segundo: %d, Primeiro: %d", primeiro, segundo))
                .subscribe(elementos::add);

        log.info(elementos.toString());
        log.info(String.valueOf(elementos.size()));

    }
}
