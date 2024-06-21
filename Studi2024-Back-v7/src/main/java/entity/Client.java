package entity;

import jakarta.persistence.*;

import java.util.List;

import entity.Ticket;
import entity.Administrator;
import entity.Key;
import entity.Client;
import org.jetbrains.annotations.NotNull;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Administrator> listOfAdministrators;

    @OneToOne
    private Key key1;

    @OneToMany
    private List<Ticket> listOfTickets;


    private String name;
    private String surname;
    private String email;
    private String password;
    public boolean isLogged;
    private long moneyInBasket;


    public Client() {
    }

    public Client(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.moneyInBasket = 0;
    }

    public Client(String name, String surname, String email, String password, Key key1) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.key1 = key1;
        this.moneyInBasket = 0;
    }

    // Definition of the setters and the getters

    public Long getId() {
        return id;
    }

    public List<Ticket> getTicket() {
        return this.listOfTickets;
    }

    public void setTicket(Ticket ticket) {
        listOfTickets.add(ticket);
    }

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

    // Other shaped methods


    public Key getKey1() {
        return this.key1;
    }

    public Client createAccount() {
        return new Client();
    }

    public void login() {
        // Permits to the client to login
    }

    public void logout() {
        // Permits to the client to logout
    }

    public void changePassword(String Password) {
        // Permits to the client to change his password
    }

    public void deleteAccount() {
        // Permits to the client to delete his account
    }

    public void payTicket(Ticket ticket) {
        // Permits to the client to pay his ticket
    }

// setMoneyInBasket and getMoneyInBasket

    public void setMoneyInBasket(long moneyInBasket) {
        this.moneyInBasket = moneyInBasket;
    }

    public long getMoneyInBasket() {
        return moneyInBasket;
    }

    public void addMoneyInBasket(Integer thePriceOfTheTicket) {
        
    }
}



