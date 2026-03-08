package performance.monolith.pagamento;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
@Data
public class cdPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;

    private BigDecimal valor;

    private String status; // PENDENTE, APROVADO, RECUSADO

    private LocalDateTime dataPagamento;


}