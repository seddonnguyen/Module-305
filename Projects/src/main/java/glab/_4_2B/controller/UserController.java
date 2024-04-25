package glab._4_2B.controller;

import glab._4_2B.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserController {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("usersDb_4_2B.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {

            findUserHqlFrom(session);
            findUserHqlSelect(session);
            getRecordById(session);
            getRecords(session);
            getMaxSalary(session);
            getCountUsers(session);
            getMaxSalaryGroupBy(session);
            namedQueryExample(session);
        }
    }

    public static void findUserHqlFrom(Session session) {
        String hqlFrom = "FROM User"; // Example of HQL to get all records of user class
        TypedQuery<User> query = session.createQuery(hqlFrom, User.class);
        List<User> results = query.getResultList();

        System.out.printf("%s%13s%17s%34s%n", "|User Id", "|Full name", "|Email", "|Password");
        for (User u : results) {
            System.out.printf(" %-10d %-20s %-30s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword());
        }
    }

    public static void findUserHqlSelect(Session session) {
        String hqlSelect = """
                           SELECT u
                           FROM User u""";
        TypedQuery<User> query = session.createQuery(hqlSelect, User.class);
        List<User> results = query.getResultList();

        System.out.printf("%s%13s%17s%34s%n", "|User Id", "|Full name", "|Email", "|Password");
        for (User u : results) {
            System.out.printf(" %-10d %-20s %-30s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword());
        }
    }

    public static void getRecordById(Session session) {
        String hql = """
                     FROM User u
                     WHERE u.id > 2
                     ORDER BY u.salary DESC""";
        TypedQuery<User> query = session.createQuery(hql, User.class);
        List<User> results = query.getResultList();
        System.out.printf("%s%13s%17s%34s%21s%n", "|User Id", "|Full name", "|Email", "|Password", "|Salary");
        for (User u : results) {
            System.out.printf(" %-10d %-20s %-30s %-23s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword(), u.getSalary());
        }
    }

    public static void getRecords(Session session) {
        TypedQuery<Object[]> query = session.createQuery("""
                                                         SELECT U.salary, U.fullName
                                                         FROM User AS U""", Object[].class);
        List<Object[]> results = query.getResultList();
        System.out.printf("%s%13s%n", "Salary", "City");
        for (Object[] a : results) {
            System.out.printf("%-16s%s%n", a[0], a[1]);
        }
    }

    public static void getMaxSalary(Session session) {
        String hql = """
                     SELECT max(U.salary)
                     FROM User U""";
        TypedQuery<Object> query = session.createQuery(hql, Object.class);
        Object result = query.getSingleResult();
        System.out.printf("%s%s", "Maximum Salary:", result);
    }

    public static void getCountUsers(Session session) {
        String hqlCount = """
                          SELECT count(*)
                          FROM User U""";
        TypedQuery<Object> query = session.createQuery(hqlCount, Object.class);
        Object result = query.getSingleResult();
        System.out.printf("Total Users: %s\n", result);
    }

    public static void getMaxSalaryGroupBy(Session session) {
        String hql = """
                     SELECT SUM(U.salary), U.city
                     FROM User U
                     GROUP BY U.city""";
        TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> result = query.getResultList();
        for (Object[] o : result) {
            System.out.println("Total salary " + o[0] + " | city: " + o[1]);
        }
    }

    public static void namedQueryExample(Session session) {
        String hql = """
                     FROM User u
                     WHERE u.id = :id""";
        TypedQuery<User> query = session.createQuery(hql, User.class);
        query.setParameter("id", 2);
        List<User> result = query.getResultList();

        System.out.printf("%s%13s%17s%34s%21s%n", "|User Id", "|Full name", "|Email", "|Password", "|Salary");
        for (User u : result) {
            System.out.printf(" %-10d %-20s %-30s %-23s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword(), u.getSalary());
        }
    }
}