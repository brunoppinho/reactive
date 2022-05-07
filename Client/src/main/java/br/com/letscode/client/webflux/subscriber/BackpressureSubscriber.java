package br.com.letscode.client.webflux.subscriber;

import br.com.letscode.client.webflux.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class BackpressureSubscriber implements Subscriber<Pessoa> {

    int onNextAmount;
    private Subscription s;

    @Override
    public void onSubscribe(Subscription s) {
        this.s = s;
        s.request(2);
        log.info("Vamos começar o processamento e iremos processar apenas 2 elementos");
    }

    @Override
    public void onNext(Pessoa pessoa) {
        log.info("Processando {}", pessoa);
        // Se chegarmos no nosso máximo vamos chamar para processar novamente mais 2 elementos.
        onNextAmount++;
        if (onNextAmount % 2 == 0) {
            log.info("Respira fundo!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            s.request(2);
        }
    }

    @Override
    public void onError(Throwable t) {
        log.error("Erro ao processar", t);

    }

    @Override
    public void onComplete() {
        log.info("Acabou o processamento");

    }
}

