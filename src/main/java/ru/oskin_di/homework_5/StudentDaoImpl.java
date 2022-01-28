package ru.oskin_di.homework_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void createMarkStudent(Student student, int mark) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            student.setMark(mark);
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student getStudentById(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = (List<Student>) session.createQuery("from Student").list();
            session.getTransaction().commit();
            return students;
        }
    }
}
