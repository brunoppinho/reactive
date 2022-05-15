package br.com.letscode.client.webflux.subscriber;

import br.com.letscode.client.webflux.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class SimplePessoaSubscriber implements Subscriber<Pessoa> {

    @Override
    public void onSubscribe(Subscription s) {
        long nroElementosMax = Long.MAX_VALUE;
        log.info("Iniciando o processamento!");
        s.request(nroElementosMax);
    }

    @Override
    public void onNext(Pessoa pessoa) {
        log.info("Processando {}", pessoa);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
