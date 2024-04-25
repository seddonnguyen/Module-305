package glab._5_1B.runner;

import glab._5_1B.model.Department;
import glab._5_1B.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        oneToMany();
    }

    public static void oneToMany() {
        SessionFactory factory = new Configuration().configure("teacher_db_5_1B.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //creating departments
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");
        session.persist(dept1);
        session.persist(dept2);

        //creating teacher
        Teacher t1 = new Teacher("1000", "MHaseeb");
        Teacher t2 = new Teacher("2220", "Shahparan");
        Teacher t3 = new Teacher("3000", "James");
        Teacher t4 = new Teacher("40000", "Joseph");
        Teacher t5 = new Teacher("200", "Ali");

        //Add teacher entity object to the list
        ArrayList<Teacher> teachersList = new ArrayList<>();
        teachersList.add(t1);
        teachersList.add(t2);
        teachersList.add(t3);
        teachersList.add(t4);
        teachersList.add(t5);
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);
        //Creating Department
        Department department = new Department();
        department.setName("Development");
        department.setTeacherList(teachersList);
        //Storing Department
        session.persist(department);
        t.commit();
    }

    public static void manyToOne() {
        SessionFactory factory = new Configuration().configure("teacher_db_5_1B.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //creating departments
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        //creating teacher
        Teacher t1 = new Teacher("1000", "MHaseeb", dept1);
        Teacher t2 = new Teacher("2220", "Shahparan", dept1);
        Teacher t3 = new Teacher("3000", "James", dept1);
        Teacher t4 = new Teacher("40000", "Joseph", dept2);
        //Storing Departments in database
        session.persist(dept1);
        session.persist(dept2);
        //Storing teachers  in database
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        transaction.commit();
    }
}