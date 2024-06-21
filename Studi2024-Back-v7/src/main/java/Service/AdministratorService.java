package Service;

import entity.Client;
import entity.Event;
import entity.Ticket;

import repository.ClientRepository;
import repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.Constants;

import entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdministratorRepository;
import util.Global;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator createAccountAdministrator(String name, String surname, String email, String password) {
        Administrator admin = new Administrator(name, surname, email, password);
        return administratorRepository.save(admin);
    }

    @Autowired
    private ClientRepository clientRepository;

    public Client createAccountClient(String name, String surname, String email, String password) {
        Client client = new Client(name, surname, email, password);
        return clientRepository.save(client);
    }


    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(client);
    }

    public void changeClientPassword(Long id, String newPassword) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setPassword(newPassword);
        clientRepository.save(client);
    }

    @Autowired
    TicketRepository ticketRepository;

    public void deleteClientTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }

    public void changeAdministratorPassword(Administrator administrator, String newPassword) {
        administrator.changeAdministratorPassword(newPassword);
    }

    public Integer numberRemainedPlaces() {
        int totalPlaces = Constants.TOTAL_PLACES;
        int evenSoldTickets = Global.orderedTickets;
        return (totalPlaces - evenSoldTickets);
    }
}