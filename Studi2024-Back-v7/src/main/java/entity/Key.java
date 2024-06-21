package entity;

import jakarta.persistence.*;
import util.EnumKey;


@Entity
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    Client client;

    @OneToOne
    Event event;

    EnumKey typeOfKey;

    private String hashValue;

    public Key() {
    }

    public Key(Client client, Event event, EnumKey typeOfKey) {
        this.client = client;
        this.event = event;
        this.typeOfKey = typeOfKey;
    }

    public Key(Client client, EnumKey typeOfKey) {
        this.client = client;
        this.typeOfKey = typeOfKey;
    }


    // Getters and setters


    public String getHashValue() {
        return this.hashValue;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EnumKey getTypeOfKey() {
        return EnumKey.first;
    }

    // Rest of the functions

    private void createKey() {
        // Generate a random key
    }

    public void setTypeOfKey(EnumKey typeOfKey) {
        this.typeOfKey = typeOfKey;
    }
}


