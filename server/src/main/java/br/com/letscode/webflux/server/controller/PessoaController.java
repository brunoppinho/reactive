package br.com.letscode.webflux.server.controller;

import br.com.letscode.webflux.server.model.Pessoa;
import br.com.letscode.webflux.server.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PessoaController {

    private final PessoaService service;

    @GetMapping("pessoa")
    public Flux<Pessoa> lista() {
        return service.lista();
    }

    @GetMapping("pessoa/{cpf}")
    public Mono<Pessoa> lista(@PathVariable String cpf) {
        return service.obtem(cpf);
    }

    @PostMapping("pessoa")
    public Mono<Pessoa> adiciona(@RequestBody Pessoa pessoa) {
        return service.adiciona(pessoa);
    }

}
