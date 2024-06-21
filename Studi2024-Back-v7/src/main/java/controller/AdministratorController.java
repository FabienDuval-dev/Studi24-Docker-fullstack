package controller;

import util.Constants;
import util.Global;
import util.AdminEndpoints;
import util.ClientEndpoints;

import entity.Administrator;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Service.AdministratorService;

@RestController
@RequestMapping()
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping(AdminEndpoints.ADMIN)
    public Administrator createAdministrator(@RequestBody Administrator admin) {
        return administratorService.createAccountAdministrator(admin.getName(), admin.getSurname(), admin.getEmail(), admin.getPassword());
    }

    @PutMapping(AdminEndpoints.ADMIN_PASSWORD)
    public void changeAdministratorPassword(@RequestParam Administrator administrator, @RequestParam String newPassword) {
        administratorService.changeAdministratorPassword(administrator, newPassword);
    }

// Create, Delete the client account

    @DeleteMapping(ClientEndpoints.CLIENT_ID)
    public void deleteClient(@PathVariable Long id) {
        administratorService.deleteClient(id);
    }

    @PostMapping(ClientEndpoints.CLIENT_CREATE)
    public Client createClient(@RequestBody Client client) {
        return administratorService.createAccountClient(client.getName(), client.getSurname(), client.getEmail(), client.getPassword());
    }

    @DeleteMapping(ClientEndpoints.CLIENT_ID)
    public void deleteClientTicket(@PathVariable Long id) {
        administratorService.deleteClient(id);
    }

    @GetMapping(AdminEndpoints.ADMIN)
    public int getnumberRemainedPlaces() {
        int totalPlaces = Constants.TOTAL_PLACES;
        int remainedPlaces = totalPlaces - Global.orderedTickets;
        return remainedPlaces;
    }

}