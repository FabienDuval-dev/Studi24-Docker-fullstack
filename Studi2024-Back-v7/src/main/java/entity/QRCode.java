package entity;
import jakarta.persistence.*;

@Entity
public class QRCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    Client client;

    @OneToOne
    Image imageQRCode;

    private String stringQRCode;

    public QRCode(Client client, Image imageQRCode) {
        this.client = client;
        this.imageQRCode = imageQRCode;
    }

    public QRCode() {
    }

    public QRCode(Ticket ticket) {
        this.client = ticket.getClient();
        this.generateQRCode();
    }

    public QRCode(String stringQRCode) {
        this.stringQRCode = stringQRCode;
        this.generateQRCode();
    }

    public QRCode(Key key1, Key key2) {
        String qrString = new String();
        qrString = key1.getHashValue() + key2.getHashValue();
        this.stringQRCode = qrString;
    }


    // Getters and setters

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Image getImageQRCode() {
        return imageQRCode;
    }

    public void setImageQRCode(Image imageQRCode) {
        this.imageQRCode = imageQRCode;
    }

    // The rest of my functions

    public QRCode generateQRCode() {
        // Generate QR code
        return new QRCode();
    }

    public Image displayImage(QRCode qrCode) {
        return new Image(qrCode);
    }
}
