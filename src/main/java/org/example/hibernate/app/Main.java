package org.example.hibernate.app;

import org.example.hibernate.app.model.Client;
import org.example.hibernate.app.model.Planet;
import org.example.hibernate.app.model.Ticket;
import org.example.hibernate.app.service.ClientCrudService;
import org.example.hibernate.app.service.PlanetCrudService;
import org.example.hibernate.app.service.TicketCrudService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);
        TicketCrudService ticketService = new TicketCrudService(sessionFactory);

        Client client = new Client();
        client.setName("Test Client");
        clientService.createClient(client);

        Planet planet = new Planet();
        planet.setId("TEST");
        planet.setName("Test Planet");
        planetService.createPlanet(planet);

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setClient(client);
        ticket.setFromPlanet(planet);
        ticket.setToPlanet(planet);

        ticketService.createTicket(ticket);

        Ticket retrievedTicket = ticketService.getTicket(ticket.getId());
        System.out.println("Retrieved Ticket ID: " + retrievedTicket.getId());

        retrievedTicket.setCreatedAt(LocalDateTime.of(2023, 1, 1, 0, 0));
        ticketService.updateTicket(retrievedTicket);
        Ticket updatedTicket = ticketService.getTicket(retrievedTicket.getId());
        System.out.println("Updated Ticket Date: " + updatedTicket.getCreatedAt());

        ticketService.deleteTicket(updatedTicket.getId());
        Ticket deletedTicket = ticketService.getTicket(updatedTicket.getId());
        System.out.println("Deleted Ticket: " + (deletedTicket == null));

        sessionFactory.close();
    }
}
