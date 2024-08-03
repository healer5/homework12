package org.example.hibernate.app;
import org.example.hibernate.app.model.Client;
import org.example.hibernate.app.model.Planet;
import org.example.hibernate.app.service.ClientCrudService;
import org.example.hibernate.app.service.PlanetCrudService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);

        Client client = new Client();
        client.setName("Test Client");

        clientService.createClient(client);

        Client retrievedClient = clientService.getClient(client.getId());
        System.out.println("Retrieved Client: " + retrievedClient.getName());

        retrievedClient.setName("Updated Client");
        clientService.updateClient(retrievedClient);
        Client updatedClient = clientService.getClient(retrievedClient.getId());
        System.out.println("Updated Client: " + updatedClient.getName());

        clientService.deleteClient(updatedClient.getId());
        Client deletedClient = clientService.getClient(updatedClient.getId());
        System.out.println("Deleted Client: " + (deletedClient == null));

        Planet planet = new Planet();
        planet.setId("TEST");
        planet.setName("Test Planet");

        planetService.createPlanet(planet);

        Planet retrievedPlanet = planetService.getPlanet(planet.getId());
        System.out.println("Retrieved Planet: " + retrievedPlanet.getName());

        retrievedPlanet.setName("Updated Planet");
        planetService.updatePlanet(retrievedPlanet);
        Planet updatedPlanet = planetService.getPlanet(retrievedPlanet.getId());
        System.out.println("Updated Planet: " + updatedPlanet.getName());

        planetService.deletePlanet(updatedPlanet.getId());
        Planet deletedPlanet = planetService.getPlanet(updatedPlanet.getId());
        System.out.println("Deleted Planet: " + (deletedPlanet == null));

        sessionFactory.close();
    }
}
