package repository;

import entity.Client;
import entity.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    QRCode findByClient(Client client);
}