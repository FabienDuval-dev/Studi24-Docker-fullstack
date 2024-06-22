package org.example.studiexam2024backendspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class StudiExam2024BackEndSpringBootApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

// Utiliser les variables d'environnement
        String dbUrl = dotenv.get("DATABASE_URL");
        String dbUsername = dotenv.get("DATABASE_USERNAME");
        String dbPassword = dotenv.get("DATABASE_PASSWORD");

        // Afficher les variables pour vérification
        System.out.println("Hello world!");
        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database Username: " + dbUsername);
        System.out.println("Database Password: " + dbPassword);

        SpringApplication.run(StudiExam2024BackEndSpringBootApplication.class, args);
    }

}
