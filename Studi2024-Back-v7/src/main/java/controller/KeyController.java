package controller;

import entity.Key;
import entity.Client;
import entity.Event;

import Service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import util.ClientEndpoints;

import org.springframework.web.bind.annotation.*;


@RestController
public class KeyController {

    @Autowired
    private Service.ClientService clientService;

    @PutMapping(ClientEndpoints.CLIENT_KEY)
    public void createKey2(@PathVariable Event event) {
        Key key2 = new Key();
        key2 = event.getKey2();
    }


// The key1 is created on the front-end side.
// The goal is to convert locally the keys into a hashcode (a String)

}