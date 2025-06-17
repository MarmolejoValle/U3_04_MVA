package utez.edu.mx.u3_04_mva.Controller.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
