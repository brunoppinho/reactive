package br.com.letscode.reactor.exemplos;

import br.com.letscode.reactor.subscriber.SimpleSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FluxoNovoSubscriber {

    public static void main(String[] args) {
        List<Integer> elementos = new ArrayList<>();
        SimpleSubscriber subscriber = new SimpleSubscriber();

        Flux<Integer> fluxo = Flux.just(2, 4, 6, 8, 10);
//        Adicionar um fluxo com um numero impar para ver o tratamento de erro
//        Flux<Integer> fluxo = Flux.just(2, 3, 6, 8);
        fluxo.log().subscribe();

        log.info(String.valueOf(subscriber.elementos.size()));

        //O fluxo está lá e podemos ter outro subscriber associado
//        fluxo.log().subscribe(elementos::add);
//        log.info(String.valueOf(elementos.size()));

    }
}
