package br.com.letscode.reactor.exemplos;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Paralelismo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> elementos = new ArrayList<>();

        Flux.just(2, 4, 6, 8, 10)
                .log()
                .subscribe(elementos::add);

        log.info("Em sequência: {}", elementos);

        elementos = new ArrayList<>();
        Flux.just(1, 3, 5, 7, 9)
                .log()
                .subscribeOn(Schedulers.parallel())
                .subscribe(elementos::add);

        // Detalhe é que quando colocamos em paralelo a Main thread continua executando. Sem o sleep não é possível
        // ver nada acontecendo.
        Thread.sleep(1000);
        log.info("Em paralelo: {}", elementos);

    }

}
