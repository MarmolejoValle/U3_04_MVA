package utez.edu.mx.u3_04_mva.Service.Client;

import org.springframework.stereotype.Service;
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
    public ClientEntity add(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }
    public ClientEntity update(ClientEntity client){
        ClientEntity clientEntity = clientRepository.findById(client.getId()).get();
        clientEntity.setEmail(client.getEmail());
        clientEntity.setFullName(client.getFullName());
        clientEntity.setPhoneNumber(client.getPhoneNumber());
        return clientRepository.save(clientEntity);
    }
    public String delete(Long id){
        ClientEntity clientEntity = clientRepository.findById(id).get();
        clientRepository.delete(clientEntity);
        return "Deleted successfully";
    }
}
