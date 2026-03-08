package performance.monolith.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface clienteRepository extends JpaRepository<cdCliente, Integer> {

    Optional<cdCliente> findById(String id);


}