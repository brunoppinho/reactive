package br.com.letscode.webflux.server.repository;

/*
Versão antiga, sem o reativo

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
 */

import br.com.letscode.webflux.server.model.Pessoa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
// Navegar pela classe ReactiveMongoRepository
public interface PessoaRepository extends ReactiveMongoRepository<Pessoa, String> {

    // Método de busca específico personalizado.
    Mono<Pessoa> findFirstByCpf(String cpf);
}
