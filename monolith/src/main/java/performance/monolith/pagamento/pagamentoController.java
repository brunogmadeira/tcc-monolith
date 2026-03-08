package performance.monolith.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class pagamentoController {

    @Autowired
    private pagamentoService pagamentoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<cdPagamento> getPagamentoById(@PathVariable("id") Integer id) {
        cdPagamento pagamento = pagamentoService.buscarPorId(id);
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping
    public ResponseEntity<List<cdPagamento>> listarPagamentos() {
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<cdPagamento>> listarPorPedido(@PathVariable Integer pedidoId) {
        return ResponseEntity.ok(pagamentoService.listarPorPedido(pedidoId));
    }

    @PostMapping
    public ResponseEntity<cdPagamento> criarPagamento(@RequestBody cdPagamento pagamento) {
        cdPagamento novoPagamento = pagamentoService.criarPagamento(pagamento);
        return ResponseEntity.ok(novoPagamento);
    }

    @PutMapping("/aprovar/{id}")
    public ResponseEntity<cdPagamento> aprovarPagamento(@PathVariable Integer id) {
        cdPagamento pagamento = pagamentoService.aprovarPagamento(id);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Integer id) {
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}