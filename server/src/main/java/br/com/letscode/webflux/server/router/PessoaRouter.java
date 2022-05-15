package br.com.letscode.webflux.server.router;

import br.com.letscode.webflux.server.handler.PessoaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class PessoaRouter {

    @Bean
    public RouterFunction<ServerResponse> getPessoa(PessoaHandler handler) {
        return RouterFunctions
                .route(GET("/router/pessoa").and(accept(MediaType.APPLICATION_JSON)),
                        handler::lista);
    }
}
