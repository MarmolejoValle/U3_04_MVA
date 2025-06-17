package utez.edu.mx.u3_04_mva.Service.Client;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientEntity;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientRepository;

import java.util.List;

@Service
public class ClientServices {
    private final ClientRepository clientRepository;
    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<ClientEntity> getClients(){
        return clientRepository.findAll();
    }
}
