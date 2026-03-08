package performance.monolith.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class pedidoService {

    private final pedidoRepository pedidoRepository;

    public cdPedido criarPedido(cdPedido pedido){
        pedido.setStatus("CRIADO");
        return pedidoRepository.save(pedido);
    }

    public List<cdPedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public cdPedido buscarPorId(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<cdPedido> buscarPorCliente(Long clienteId){
        return pedidoRepository.findByClienteId(clienteId);
    }

    public cdPedido atualizarStatus(Long id, String status){
        cdPedido pedido = buscarPorId(id);
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

}