package entity;

import jakarta.persistence.*;

import java.util.Date;
import entity.Ticket;
import entity.Client;
import entity.Key;


@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private Client client;

    private Date date;
    private String clientLocation;

    @OneToOne
    private Key key2;

    public Event() {
    }

    public Event(Ticket ticket) {
        this.ticket = ticket;
    }

    public Event(Ticket ticket, Client client, Date date, String clientLocation) {
        this.ticket = ticket;
        this.client = client;
        this.date = date;
        this.clientLocation = clientLocation;
    }

    public Event(Ticket ticket, Client client, Date date, String clientLocation, Key key2) {
        this.ticket = ticket;
        this.client = client;
        this.date = date;
        this.clientLocation = clientLocation;
        this.key2 = key2;
    }

    // First, the getters and the setters


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public Key getKey2() {
        return key2;
    }

    public void setKey2(Key key2) {
        this.key2 = key2;
    }

    // Definition of rest of the methods of the class

    public Event createEvent() {
        return new Event();
    }

    public void deleteEvent(Event event) {
        //deleteEvent
    }

    public Integer getPriceOfTicket(Ticket ticket) {
        return ticket.getPrice();
    }
}
