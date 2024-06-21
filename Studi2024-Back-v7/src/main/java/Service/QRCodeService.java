package Service;

import entity.Ticket;
import entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import entity.QRCode;
import repository.QRCodeRepository;

@Service
public class QRCodeService {
    @Autowired
    private QRCodeRepository qrCodeRepository;

    @Autowired
    private ImageService imageService;

    public QRCode createQRCode(Ticket ticket) {
        QRCode qrCode = new QRCode(ticket);
        return qrCodeRepository.save(qrCode);
    }

    public Image generateQRCodeImage(QRCode qrCode) {
        return new Image();
    }
}
