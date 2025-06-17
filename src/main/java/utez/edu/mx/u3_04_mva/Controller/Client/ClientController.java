package utez.edu.mx.u3_04_mva.Controller.Client;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientEntity;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientRepository;
import utez.edu.mx.u3_04_mva.Service.Client.ClientServices;

import java.util.List;

@RestController
@RequestMapping("/api/client/")
public class ClientController {
    private final ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getClients(){
        return ResponseEntity.ok(clientServices.getClients());
    }
    @PostMapping
    public ResponseEntity<ClientEntity> addClient(@Validated @RequestBody ClientEntity clientEntity){
        return ResponseEntity.ok().body(clientServices.add(clientEntity));
    }
    @PutMapping
    public ResponseEntity<ClientEntity> updateClient(@Validated @RequestBody ClientEntity clientEntity){
        return ResponseEntity.ok().body(clientServices.update(clientEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        return ResponseEntity.ok().body(clientServices.delete(id));
    }

}
