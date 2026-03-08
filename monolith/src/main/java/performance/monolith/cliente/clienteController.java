package performance.monolith.cliente;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private clienteRepository clienteRp;

    @GetMapping("/id/{id}")
    public ResponseEntity<cdCliente> getClienteById(@PathVariable("id") Integer id) {
        cdCliente cliente = clienteRp.findById(id).get();
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/save")
    public ResponseEntity<cdCliente> createCliente(@RequestBody cdCliente cliente){
        cdCliente novoCliente = clienteRp.save(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id){
        clienteRp.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
