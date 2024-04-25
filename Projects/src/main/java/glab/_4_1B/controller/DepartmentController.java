package glab._4_1B.controller;

import glab._4_1B.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentController {
    public static void main(String[] args) {
        // Perform CRUD operations on Department entity

        try (SessionFactory factory = new Configuration().configure("usersDb_4_1B.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {

            // Add Department
            Department department1 = new Department("Engineering", "CA");
            boolean add = addDepartment(session, department1);
            if (add) {
                System.out.printf("Department added successfully, id: %d\n", department1.getId());
            } else {
                System.out.println("Department not added");
            }

            // Add List of Departments
            Department department2 = new Department("IT", "NYC");
            Department department3 = new Department("HR", "Dallas");
            Department department4 = new Department("Finance", "Chicago");
            Department department5 = new Department("Marketing", "NJ");
            Department department6 = new Department("Sales", "LA");

            List<Department> departments = List.of(department2, department3, department4, department5, department6);
            boolean addDepartments = addDepartment(session, departments);
            if (addDepartments) {
                for (Department department : departments) {
                    System.out.printf("Department added successfully, id: %d\n", department.getId());
                }
            } else {
                System.out.println("Departments not added");
            }

            int departmentId = 2;

            // Retrieve Department
            Department department = getDepartment(session, departmentId);
            if (department != null) {
                System.out.printf("Retrieve successful, Department id: %d\n", departmentId);
            } else {
                System.out.printf("Retrieve unsuccessful, Department id: %d\n", departmentId);
            }

            // Update Department's Name
            String name = "Human Resources";
            Department updateName = updateDepartmentName(session, departmentId, name);
            if (updateName != null) {
                System.out.printf("Update department's name successful, Department id: %d\n", departmentId);
            } else {
                System.out.printf("Update department's name unsuccessful, Department id: %d\n", departmentId);
            }

            // Update Department's State
            String state = "DC";
            Department updateState = updateDepartmentState(session, departmentId, state);
            if (updateState != null) {
                System.out.printf("Update department's state successful, Department id: %d\n", departmentId);
            } else {
                System.out.printf("Update department's state unsuccessful, Department id: %d\n", departmentId);
            }

            // Delete Department
            boolean delete = deleteDepartment(session, departmentId);
            if (delete) {
                System.out.printf("Delete successfully, Department id: %d\n", departmentId);
            } else {
                System.out.printf("Delete unsuccessful, Department id: %d\n", departmentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addDepartment(Session session, Department department) {
        Transaction transaction = session.beginTransaction();
        boolean successful = false;

        try {
            session.persist(department);
            transaction.commit();
            successful = true;
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
        return successful;
    }

    public static boolean addDepartment(Session session, List<Department> departments) {
        Transaction transaction = session.beginTransaction();
        boolean successful = false;

        try {
            for (Department department : departments) {
                session.persist(department);
            }
            transaction.commit();
            successful = true;
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
        return successful;
    }

    public static Department getDepartment(Session session, int id) {
        Department department = null;
        try {
            department = session.get(Department.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    public static Department updateDepartmentName(Session session, int id, String name) {
        Transaction transaction = null;
        Department department = null;

        try {
            department = getDepartment(session, id);
            if (department == null) { return null; }

            transaction = session.beginTransaction();
            department.setName(name);
            department = session.merge(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
        return department;
    }


    public static Department updateDepartmentState(Session session, int id, String state) {
        Transaction transaction = null;
        Department department = null;

        try {
            department = getDepartment(session, id);
            if (department == null) { return null; }

            transaction = session.beginTransaction();
            department.setState(state);
            department = session.merge(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
        return department;
    }

    public static boolean deleteDepartment(Session session, int id) {
        Transaction transaction = null;
        boolean successful = false;

        try {
            Department department = getDepartment(session, id);
            if (department == null) { return false; }

            transaction = session.beginTransaction();
            session.remove(department);
            transaction.commit();

            successful = true;
        } catch (Exception e) {
            if (transaction != null) { transaction.rollback(); }
            e.printStackTrace();
        }
        return successful;
    }
}