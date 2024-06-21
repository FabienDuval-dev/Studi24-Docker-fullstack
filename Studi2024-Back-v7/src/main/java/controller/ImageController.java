package controller;


import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import util.ClientEndpoints;

@RestController
public class ImageController {

    @Autowired
    Service.ImageService imageService;

    @Autowired
    Service.KeyService keyService;

    @PostMapping(ClientEndpoints.CLIENT_QRCODE)
    public void DisplayImage(@RequestParam Ticket ticket, @RequestParam Client client) {

        Key key1 = client.getKey1();
        Key key2 = ticket.getKey2();

        String stringForQRCode = key1.getHashValue() + key2.getHashValue();

        QRCode qrCode = new QRCode(stringForQRCode); // generate a QR type object

        Image image = qrCode.displayImage(qrCode); // Transform the QR code into a PNG file.
    }
}
