package entity;

import entity.*;


import jakarta.persistence.*;
import util.Constants;
import util.Global;

import java.util.List;

@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;

    @ManyToMany
    private List<Client> listClients;

    @ManyToMany
    private List<Ticket> listTickets;

    public Administrator() {
    }

    public Administrator(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    // Definition of the methods of the class

    // First, the getter and setter methods, to access to my objects


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Client> getClient() {
        return this.listClients;
    }

    public void setClient(Client client) {
        listClients.add(client);
    }

    public List<Ticket> getTicket() {
        return this.listTickets;
    }

    public void setTicket(Ticket ticket) {
        listTickets.add(ticket);
    }

    // Secondly, I will create specific methods of each Administrator objects

    private Administrator createAccountAdministrator() {
        // This method will create an account for an administrator
        return new Administrator();
    }

    private Client createAccountClient() {
        // This method will create an account for a client
        return new Client();
    }

    private void deleteClient(Client client) {
        // This method will delete a client
    }

    private void deleteClientTicket(Ticket ticket) {
        // This method will delete a ticket of a client
    }

    public void changeAdministratorPassword(String password) {
        // This method will change the password of an administrator
    }

    private Integer numberRemainedPlaces() {
        // This method will return the number of places remained for an event
        int totalPlaces = Constants.TOTAL_PLACES;
        int evenSoldPlaces = Global.orderedTickets;
        return (totalPlaces - evenSoldPlaces);
    }
}
