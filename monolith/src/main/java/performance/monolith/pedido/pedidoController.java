package performance.monolith.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class pedidoController {

    private final pedidoService pedidoService;

    @PostMapping
    public cdPedido criarPedido(@RequestBody cdPedido pedido){
        System.out.println(pedido);
        return pedidoService.criarPedido(pedido);
    }

    @GetMapping
    public List<cdPedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public cdPedido buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<cdPedido> buscarPorCliente(@PathVariable Long clienteId){
        return pedidoService.buscarPorCliente(clienteId);
    }

    @PatchMapping("/{id}/status")
    public cdPedido atualizarStatus(@PathVariable Long id,
                                    @RequestParam String status){
        return pedidoService.atualizarStatus(id, status);
    }

}