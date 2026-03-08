package performance.monolith.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private clienteService clienteService;

    @GetMapping("/id/{id}")
    public ResponseEntity<cdCliente> getClienteById(@PathVariable("id") Integer id) {
        cdCliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<cdCliente>> listaCliente() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    public ResponseEntity<cdCliente> createCliente(@RequestBody cdCliente cliente){
        System.out.println(cliente);
        cdCliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}