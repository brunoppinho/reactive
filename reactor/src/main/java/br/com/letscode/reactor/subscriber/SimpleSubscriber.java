package br.com.letscode.reactor.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SimpleSubscriber implements Subscriber<Integer> {

    public List<Integer> elementos = new ArrayList<>();

    @Override
    public void onSubscribe(Subscription s) {
        long nroElementosMax = Long.MAX_VALUE;
//                Alterar para menos elementos
//                long nroElementosMax = 2;
        log.info("Vamos começar o processamento e iremos processar {}", nroElementosMax);
        s.request(nroElementosMax);
    }

    @Override
    public void onNext(Integer integer) {
        log.info("Recebendo o elemento {}", integer);
        if (integer % 2 == 1) {
            throw new RuntimeException("Não processamos número ímpar");
        }
        elementos.add(integer);
    }

    @Override
    public void onError(Throwable t) {
        log.error("Tratamento do erro. Interrompe o fluxo", t);
    }

    @Override
    public void onComplete() {
        log.info("Terminamos, o tamanho do vetor resultante foi: {}", elementos.size());
    }
}
