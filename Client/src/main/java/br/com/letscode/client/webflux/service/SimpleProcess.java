package br.com.letscode.client.webflux.service;

import br.com.letscode.client.webflux.model.Pessoa;
import br.com.letscode.client.webflux.subscriber.BackpressureSubscriber;
import br.com.letscode.client.webflux.subscriber.SimplePessoaSubscriber;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class SimpleProcess {

    private final WebClient webClient;

    public SimpleProcess() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8381")
                .build();
    }

    public void process() {
        webClient.get()
                .uri("pessoa")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Pessoa.class)
                .log()
                .subscribe(new SimplePessoaSubscriber());
    }

    public void backpressure() {
        Flux<Pessoa> pessoas = webClient.get()
                .uri("pessoa")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Pessoa.class);

        pessoas.log()
                .subscribe(new BackpressureSubscriber());
    }
}
