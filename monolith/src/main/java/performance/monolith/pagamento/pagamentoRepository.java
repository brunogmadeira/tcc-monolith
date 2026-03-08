package performance.monolith.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface pagamentoRepository extends JpaRepository<cdPagamento, Integer> {

    List<cdPagamento> findByPedidoId(Integer pedidoId);
}