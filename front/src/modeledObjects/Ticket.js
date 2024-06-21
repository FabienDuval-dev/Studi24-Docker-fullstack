import { Qrcode } from "./Qrcode";
import { Client } from "./Client";

export class Ticket {
    constructor(qrcode, client) {
        this.qrcode = new Qrcode()
        this.client = new Client();
    }
}