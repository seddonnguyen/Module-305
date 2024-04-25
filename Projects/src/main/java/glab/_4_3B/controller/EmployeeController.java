package glab._4_3B.controller;

import glab._4_3B.model.Employee;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeController {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("usersDb_4_3B.cfg.xml").buildSessionFactory();
        try (factory;
             Session session = factory.openSession()) {
            findEmployeeById(session, 1);
            findEmployeeByName(session, "Jenny Ji");
            ShowOfficeCodeAsDepartment(session);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findEmployeeById(Session session, int id) {
        TypedQuery<Object[]> query = session.createNamedQuery("getEmployeeById", Object[].class);
        query.setParameter("id", id);
        Object[] employee = query.getSingleResult();
        System.out.printf("Name: %s, Salary: %s, Job: %s%n", employee[0], employee[1], employee[2]);
    }

    public static void findEmployeeByName(Session session, String name) {
        TypedQuery<Employee> query = session.createNamedQuery("findEmployeeByName", Employee.class);
        query.setParameter("name", name);
        Employee employee = query.getSingleResult();
        System.out.println(employee);
    }

    public static void ShowOfficeCodeAsDepartment(Session session) {
        TypedQuery<Object[]> query = session.createNamedQuery("employeeDeptAlias", Object[].class);
        List<Object[]> employees = query.getResultList();
        for (Object[] employee : employees) {
            System.out.printf("Office Code: %s, Department: %s, Name: %s%n", employee[1], employee[3], employee[2]);
        }
    }
}