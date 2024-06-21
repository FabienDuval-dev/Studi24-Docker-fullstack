package entity;

import jakarta.persistence.*;

import entity.QRCode;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    QRCode qrCode;

    public Image() {
    }

    public Image(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    // Function to display image

    public void displayImage() {
        // Display image
    }
}
