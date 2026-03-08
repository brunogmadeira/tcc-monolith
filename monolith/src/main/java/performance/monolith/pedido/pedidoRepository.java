package performance.monolith.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface pedidoRepository extends JpaRepository<cdPedido, Long> {

    @Query("SELECT p FROM cdPedido p WHERE p.cliente_id = :clienteId")
    List<cdPedido> findByClienteId(Long clienteId);

}