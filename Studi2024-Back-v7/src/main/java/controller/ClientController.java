package controller;

import entity.*;

import Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import util.*;

import util.PersonalFunction;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping(ClientEndpoints.CLIENTS)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(ClientEndpoints.CLIENT_CREATE)
    public Client createClient(@RequestBody Client client) {
        Client newClient = new Client();
        client.isLogged = true;
        Key key1 = new Key(newClient, EnumKey.first);
        return newClient;
    }

    @PutMapping(ClientEndpoints.CLIENT_PASSWORD)
    public void logIn(@PathVariable Long id, @RequestParam String checkPassword) {
        Client client = new Client();
        String hashedWrittenPassword = util.PersonalFunction.hashPassword(checkPassword);
        if (hashedWrittenPassword.matches(client.getPassword())) {
            client.isLogged = true;
        } else {
            throw new RuntimeException("Wrong password");
        }
    }

    @PutMapping(ClientEndpoints.CLIENT_PASSWORD)
    public void logOut(@PathVariable Long id) {
        Client client = new Client();
        if (client == null) {
            throw new RuntimeException("Client not found");
        }
        if (client.isLogged) {
            client.isLogged = false;
        }
    }

    @PostMapping(ClientEndpoints.CLIENT_PASSWORD)
    public void changePassword(@PathVariable Long id, @RequestParam String newPassword) {
        Client client = new Client();
        if (client == null) {
            throw new RuntimeException("Client not found");
        }
        client.changePassword(newPassword);
    }


    // For the respect of the 'RGPD', the account must be deleted by the client itself.
    // The client can delete his account by himself.


    @DeleteMapping(ClientEndpoints.CLIENT_ID)
    public void deleteAccount(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            throw new RuntimeException("Client not found");
        } else {
            client.deleteAccount();
        }
    }

    @PostMapping(ClientEndpoints.TICKETS)
    public void payTicket(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            throw new RuntimeException("Client not found");
        }

        // The client is directing to the payment plateform
        // ... payment ...
        // The client has paid, and comes back to the website

        client.setMoneyInBasket(0);

        // The cost of its ticket is 0, now.
    }

    @PutMapping(ClientEndpoints.CLIENT_ID)
    public void addTicketsToBasket(@PathVariable Long id, @RequestParam Ticket ticket) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            throw new RuntimeException("Client not found");
        }
        if (ticket == null) {
            throw new RuntimeException("Ticket not found");
        }

        Event event = new Event(ticket);
        Integer thePriceOfTheTicket = event.getPriceOfTicket(ticket);
        client.addMoneyInBasket(thePriceOfTheTicket);


        Global.orderedTickets -= ticket.getPrice();
    }

    @PutMapping(ClientEndpoints.TICKETS)
    public void addTicketsToBraket(Client client, Ticket ticket) {
        Integer priceOfTicket = ticket.getPrice();
        client.addMoneyInBasket(priceOfTicket);
    }

    @PutMapping(ClientEndpoints.TICKETS)
    public void addMoneyInBasket(Long money) {
        // mockup : the client has paid
        // the money is added to the basket
    }

    @PutMapping(ClientEndpoints.TICKETS)
    public Integer getMoneyInBasket(Ticket ticket) {
        if (ticket == null) {
            throw new RuntimeException("Ticket not found");
        }
        Integer priceOfTicket = ticket.getPrice();
        return priceOfTicket;
    }
}

