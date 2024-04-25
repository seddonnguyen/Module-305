package glab._4_2B.runner;

import glab._4_2B.model.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NamedQueryExecutor {


    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("usersDb_4_2B.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {
            // Using named queries
            listUsers(session);
            // deleteUserByName(session, "Sid");
            User user = findById(session, 1); // Assume 1 is a valid ID for demonstration
            if (user != null) {
                System.out.println("Found User: " + user.getFullName());
            } else {
                System.out.println("No user found with the specified ID.");
            }
        }
    }

    public static void listUsers(Session session) {
        TypedQuery<User> query = session.createNamedQuery("User.findAll", User.class);
        for (User user : query.getResultList()) {
            System.out.println("User: " + user.getFullName());
        }
    }

    public static User findById(Session session, Integer id) {
        try {
            TypedQuery<User> query = session.createNamedQuery("User.findById", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No user found with ID: " + id);
            return null;
        }
    }

    public static void deleteUserByName(Session session, String fullName) {
        Transaction transaction = session.beginTransaction();
        try {
            Query<User> query = session.createNamedQuery("User.deleteByName", User.class);
            query.setParameter("fullName", fullName);
            int result = query.executeUpdate();
            System.out.println("Users deleted: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
    }
}