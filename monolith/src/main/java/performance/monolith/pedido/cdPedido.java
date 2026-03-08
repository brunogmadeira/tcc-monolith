package performance.monolith.pedido;

import jakarta.persistence.*;
import lombok.*;
import performance.monolith.cliente.cdCliente;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@Data
public class cdPedido {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer mesa;

    @JoinColumn(name = "cliente_id")
    private Long cliente_id;

    @Column(name = "valor_total", precision = 15, scale = 6)
    private BigDecimal valor_total;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

}