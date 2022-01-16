package ru.khrebtov.hw5;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentDao {

    private final EntityManager em;


    public StudentDao(EntityManager em) {
        this.em = em;
    }

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createQuery("from Student ", Student.class).getResultList();
    }

    public void deleteById(Long id) {
        em.createQuery("delete from Student where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("delete from Student ").executeUpdate();
        em.getTransaction().commit();
    }

    public void save(Student student) {
        em.getTransaction().begin();
        if (student.getId() == null) {
            insert(student);
        } else {
            update(student);
        }
        em.getTransaction().commit();
    }

    private void insert(Student student) {
        em.persist(student);
    }

    private void update(Student student) {
        em.merge(student);
    }
}

