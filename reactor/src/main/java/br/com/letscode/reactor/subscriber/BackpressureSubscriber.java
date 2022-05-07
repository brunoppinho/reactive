package br.com.letscode.reactor.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BackpressureSubscriber implements Subscriber<Integer> {

    public List<Integer> elementos = new ArrayList<>();

    private int onNextAmount;
    private Subscription s;

    @Override
    public void onSubscribe(Subscription s) {
        this.s = s;
        s.request(2);
        log.info("Vamos começar o processamento e iremos processar apenas 2 elementos");
    }

    @Override
    public void onNext(Integer integer) {
        log.info("Recebendos o elemento {}", integer);
        if (integer % 2 == 1) {
            throw new RuntimeException("Não processamos número ímpar");
        }
        elementos.add(integer);

        // Se chegarmos no nosso máximo vamos chamar para processar novamente mais 2 elementos.
        onNextAmount++;
        if (onNextAmount % 2 == 0) {
            s.request(2);
        }
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
