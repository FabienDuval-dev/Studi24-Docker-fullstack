package Service;

import repository.ClientRepository;
import entity.Client;

import entity.Ticket;
import repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteAccount() {
        Client client = clientRepository.findById(1L).orElseThrow(() -> new RuntimeException("Client not found"));
        client.deleteAccount();
    }
}
