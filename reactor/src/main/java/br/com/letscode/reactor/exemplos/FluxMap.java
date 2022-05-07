package br.com.letscode.reactor.exemplos;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FluxMap {

    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();

        Flux<Integer> fluxo = Flux.just(2, 4, 6, 8, 10);

        fluxo.log()
                .map(integer -> integer + 1)
                .subscribe(elementos::add);

        log.info(elementos.toString());
    }
}
