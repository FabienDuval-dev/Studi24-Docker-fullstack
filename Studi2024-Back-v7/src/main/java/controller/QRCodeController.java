package controller;

import entity.Client;
import entity.Event;
import entity.Ticket;
import entity.QRCode;
import entity.Image;
import entity.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import util.ClientEndpoints;

@RestController
@RequestMapping
public class QRCodeController {

    @Autowired
    private Service.QRCodeService qrCodeService;

    @Autowired
    private Service.ClientService clientService;

    @Autowired
    private Service.ImageService imageService;

    @PutMapping(ClientEndpoints.CLIENT_QRCODE)
    public void createQRCode(@PathVariable Long id, @RequestParam Client client, @RequestParam Ticket ticket) {

        Key key1 = client.getKey1();
        Key key2 = ticket.getKey2();

        QRCode qrCode = new QRCode(key1, key2); // generate a QR type object

        Image image = qrCode.displayImage(qrCode); // Transform the QR code into a PNG file.
    }

}