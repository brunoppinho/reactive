package br.com.letscode.reactor.exemplos;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofSeconds;

@Slf4j
public class FluxoIndeterminado {

    public static void main(String[] args) {

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
                    while (true) {
                        sleepInSeconds(1);
                        fluxSink.next(System.currentTimeMillis());
                    }
                })
//                .sample(ofSeconds(2))
                .publish();

        publish.subscribe(System.out::println);
        sleepInSeconds(5);
        publish.connect();
    }

    private static void sleepInSeconds(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException e) {
            log.info("Deu ruim!", e);
        }

    }
}
