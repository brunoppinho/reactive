package br.com.letscode.webflux.server.service;

import br.com.letscode.webflux.server.model.Pessoa;
import br.com.letscode.webflux.server.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository repository;

    public Flux<Pessoa> lista() {
        log.info("Listando pessoas");
        return repository.findAll();
    }

    public Mono<Pessoa> obtem(String cpf) {
        log.info("Listando pessoa cujo cpf é {}", cpf);
        return repository.findFirstByCpf(cpf);
    }

    public Mono<Pessoa> adiciona(Pessoa pessoa) {
        log.info("Adicionando {}", pessoa);
        return repository.insert(pessoa);
    }

}
