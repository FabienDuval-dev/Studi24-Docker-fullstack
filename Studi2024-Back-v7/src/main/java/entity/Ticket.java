package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    Key key2;

    @OneToOne
    QRCode qrCode;

    @ManyToOne
    Client client;

    @OneToMany
    List<Administrator> listOfAdministrators;


    @OneToMany
    List<Event> listOfEvent;



    private Integer priceOfTicket;
    private Integer numberOfPlaces;


// Constructors of the ticket objects

    public Ticket() {
    }

    public Ticket(Key key, QRCode qrCode, Client client,Integer numberOfPlaces, Integer priceOfTicket) {
        this.key2 = key;
        this.qrCode = qrCode;
        this.client = client;
        this.numberOfPlaces = numberOfPlaces;
        this.priceOfTicket = priceOfTicket;
    }

// Definition of the setters and the getters


    public QRCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Administrator> getAdministrator() {
        return listOfAdministrators;
    }

    public void setAdministrator(Administrator administrator) {
        listOfAdministrators.add(administrator);
    }

    public List<Event> getEvent() {
        return listOfEvent;
    }

    public void setEvent(Event event) {
       listOfEvent.add(event);
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    // Definition of the rest of the methods of the class

    public void generateQRCode(Key key1, Key key2) {
        // Generate a QR code
    }

    // getters

    public Key getKey2() {
        return this.key2;
    }

    public Integer getPrice() {
        return priceOfTicket;
    }
}


