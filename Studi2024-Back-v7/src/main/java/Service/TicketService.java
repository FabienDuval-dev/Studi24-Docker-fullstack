package Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Ticket;
import entity.QRCode;

import repository.TicketRepository;
import repository.QRCodeRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }

    public QRCode generateQRCode(Ticket ticket) {
        QRCode qrCode = new QRCode(ticket);
        return qrCode;
    }
}
