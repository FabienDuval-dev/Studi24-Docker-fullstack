package org.example.studiexam2024backendspringboot;

import entity.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testClientEquality() {
        Client client1 = new Client("John Doe", "john.doe@example.com");
        client1.setId(1L);
        Client client2 = new Client("John Doe", "john.doe@example.com");
        client2.setId(1L);

        assertEquals(client1, client2);
    }

    @Test
    public void testClientInequalityDifferentId() {
        Client client1 = new Client("John Doe", "john.doe@example.com");
        client1.setId(1L);
        Client client2 = new Client("John Doe", "john.doe@example.com");
        client2.setId(2L);

        assertNotEquals(client1, client2);
    }

    @Test
    public void testClientInequalityDifferentName() {
        Client client1 = new Client("John Doe", "john.doe@example.com");
        client1.setId(1L);
        Client client2 = new Client("Jane Doe", "john.doe@example.com");
        client2.setId(1L);

        assertNotEquals(client1, client2);
    }
}