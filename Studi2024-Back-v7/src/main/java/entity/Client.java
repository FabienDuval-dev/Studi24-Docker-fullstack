package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean isLogged;

    // Constructeurs
    public Client() {
    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    // Méthodes spécifiques
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void deleteAccount() {
        // Logique de suppression de compte
    }

    public void setMoneyInBasket(int money) {
        // Logique de mise à jour du montant dans le panier
    }

    public void addMoneyInBasket(int money) {
        // Logique d'ajout de montant dans le panier
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) &&
                isLogged == client.isLogged &&
                name.equals(client.name) &&
                email.equals(client.email) &&
                password.equals(client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, isLogged);
    }
}