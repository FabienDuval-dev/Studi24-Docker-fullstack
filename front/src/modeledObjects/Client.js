import { Ticket } from "./Ticket";
import { Qrcode } from "./Qrcode";

export class Client {
    constructor(name, surname, email, hashedPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.tickets = new Ticket();
        this.qrCode = new Qrcode();
        this.isLogged = false;
    }
}