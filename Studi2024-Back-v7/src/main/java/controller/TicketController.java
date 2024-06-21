package controller;

import entity.*;
import Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ClientEndpoints;


@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private QRCodeService keyService;

    @Autowired
    private ClientService clientService;


    @PutMapping(ClientEndpoints.CLIENT_ID)
    public void createEvent(@PathVariable Long id) {
        Event event = new Event();
    }


    @PutMapping(ClientEndpoints.CLIENT_KEY)
    public void generateKey(@PathVariable Long id) {
        Ticket ticket = new Ticket();
        Key key = new Key();
    }

    @PutMapping(ClientEndpoints.CLIENT_QRCODE)
    public Image createImageFromQrCode(@PathVariable Long id, @RequestParam Ticket ticket, @RequestParam Client client) {

        Key key1 = client.getKey1();
        Key key2 = ticket.getKey2();

        QRCode qrCode = new QRCode(key1, key2); // generate a QR type object

        Image image = qrCode.displayImage(qrCode); // Transform the QR code into a PNG file.
        return image;
    }
}
