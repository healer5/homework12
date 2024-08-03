package org.example.hibernate.app.service;

import org.example.hibernate.app.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket getTicket(long id) {
        Session session = sessionFactory.openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        Session session = sessionFactory.openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }

    public void updateTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(ticket);
        transaction.commit();
        session.close();
    }

    public void deleteTicket(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        if (ticket != null) {
            session.delete(ticket);
        }
        transaction.commit();
        session.close();
    }
}
