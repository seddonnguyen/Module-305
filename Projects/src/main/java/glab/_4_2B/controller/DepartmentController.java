package glab._4_2B.controller;

import glab._4_2B.model.Department;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentController {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("usersDb_4_2B.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {

            getAllDepartment(session);
            getDepartmentByState(session, "CA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllDepartment(Session session) {
        TypedQuery<Department> query = session.createNamedQuery("getDepartmentAll", Department.class);
        List<Department> departments = query.getResultList();
        for (Department department : departments) {
            System.out.printf("Department: %s, State: %s\n", department.getName(), department.getState());
        }
    }

    public static void getDepartmentByState(Session session, String state) {
        TypedQuery<Department> query = session.createNamedQuery("getDepartmentByState", Department.class);
        query.setParameter("state", state);
        List<Department> departments = query.getResultList();
        for (Department department : departments) {
            System.out.printf("Department: %s, State: %s\n", department.getName(), department.getState());
        }
    }
}