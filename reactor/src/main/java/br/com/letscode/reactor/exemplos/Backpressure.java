package br.com.letscode.reactor.exemplos;

import br.com.letscode.reactor.subscriber.BackpressureSubscriber;
import br.com.letscode.reactor.subscriber.SimpleSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class Backpressure {

    public static void main(String[] args) {
        BackpressureSubscriber subscriber = new BackpressureSubscriber();

        Flux<Integer> fluxo = Flux.just(2, 4, 6, 8, 10);
        fluxo.log().subscribe(subscriber);

        log.info(String.valueOf(subscriber.elementos.size()));

    }
}
