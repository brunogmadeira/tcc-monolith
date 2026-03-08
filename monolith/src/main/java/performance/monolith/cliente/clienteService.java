package performance.monolith.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    private clienteRepository clienteRp;

    public cdCliente buscarPorId(Integer id) {
        Optional<cdCliente> cliente = clienteRp.findById(id);

        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        return cliente.get();
    }

    public List<cdCliente> listarClientes() {
        return clienteRp.findAll();
    }

    public cdCliente criarCliente(cdCliente cliente) {
        return clienteRp.save(cliente);
    }

    public void deletarCliente(Integer id) {
        clienteRp.deleteById(id);
    }
}