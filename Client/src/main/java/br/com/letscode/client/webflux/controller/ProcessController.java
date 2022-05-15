package br.com.letscode.client.webflux.controller;

import br.com.letscode.client.webflux.service.SimpleProcess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProcessController {

    private final SimpleProcess client;

    @GetMapping("pessoa/process")
    public void process() {
        log.info("Iniciando processamento");
        client.process();
        log.info("Final do controller");
    }

    @GetMapping("pessoa/backpressure")
    public void backpressure() {
        log.info("Iniciando processamento");
        client.backpressure();
        log.info("Final do controller");
    }

}
