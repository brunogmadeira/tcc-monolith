package performance.monolith.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import performance.monolith.pedido.cdPedido;
import performance.monolith.pedido.pedidoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class pagamentoService {

    @Autowired
    private pagamentoRepository pagamentoRp;
    @Autowired
    private pedidoRepository pedidoRp;

    public cdPagamento buscarPorId(Integer id) {
        Optional<cdPagamento> pagamento = pagamentoRp.findById(id);

        if (pagamento.isEmpty()) {
            throw new RuntimeException("Pagamento não encontrado");
        }

        return pagamento.get();
    }

    public List<cdPagamento> listarPagamentos() {
        return pagamentoRp.findAll();
    }

    public List<cdPagamento> listarPorPedido(Integer pedidoId) {
        return pagamentoRp.findByPedidoId(pedidoId);
    }

    public cdPagamento criarPagamento(cdPagamento pagamento) {
        pagamento.setStatus("PENDENTE");
        pagamento.setDataPagamento(LocalDateTime.now());
        return pagamentoRp.save(pagamento);
    }

    public cdPagamento aprovarPagamento(Integer id) {
        cdPagamento pagamento = buscarPorId(id);
        pagamento.setStatus("APROVADO");
        pagamento.setDataPagamento(LocalDateTime.now());

        cdPagamento pag = pagamentoRp.save(pagamento);
        cdPedido pedido = pedidoRp.getById(pag.getPedidoId());
        pedido.setStatus("Pago");
        pedidoRp.save(pedido);
        return pag;
    }

    public void deletarPagamento(Integer id) {
        pagamentoRp.deleteById(id);
    }
}