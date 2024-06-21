package repository;

import entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByEmail(String email);
    List<Administrator> findByNameAndSurname(String name, String surname);
}