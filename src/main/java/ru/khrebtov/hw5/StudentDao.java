package ru.khrebtov.hw5;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static ru.khrebtov.hw5.Utils.getSessionFactory;

public class StudentDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public StudentDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Student student) {
        getCurrentSession().persist(student);
    }

    public void save(Student student) {
        getCurrentSession().save(student);
    }

    public void update(Student student) {
        getCurrentSession().update(student);
    }

    public Student findById(String id) {
        return (Student) getCurrentSession().get(Student.class, id);
    }

    public void delete(Student student) {
        getCurrentSession().delete(student);
    }

    public List<Student> findAll() {
        return (List<Student>) getCurrentSession().createQuery("from Student ").list();
    }
}

