package br.com.letscode.webflux.server.handler;

import br.com.letscode.webflux.server.model.Pessoa;
import br.com.letscode.webflux.server.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
@Slf4j
public class PessoaHandler {

    private final PessoaService service;

    public Mono<ServerResponse> lista(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.lista(), Pessoa.class);
    }
}
