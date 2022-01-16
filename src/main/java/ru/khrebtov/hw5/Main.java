package ru.khrebtov.hw5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static ru.khrebtov.hw5.Utils.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = getSessionFactory();
        EntityManager em = emFactory.createEntityManager();
        StudentDao studentDao = new StudentDao(em);
        int maxMark = 5;
        int minMark = 1;
        try {
            for (int i = 1; i <= 1000; i++) {
                int mark = (int) Math.floor(Math.random() * (maxMark - minMark + 1) + minMark);
                Student student = new Student("Student_" + i, mark);
                studentDao.save(student);
            }
            System.out.println("count Students: " + studentDao.findAll().size());

            Long idForUpdate =  studentDao.findAll().get(0).getId();
            Student student = studentDao.findById(idForUpdate);
            System.out.printf("Student with id:%s student before updating: %s \n", idForUpdate, student);
            student.setName("Updated");
            student.setMark(500);
            studentDao.save(student);
            System.out.printf("Student with id:%s student after updating: %s \n", idForUpdate, studentDao.findById(idForUpdate));

            studentDao.deleteAll();
            System.out.println("after deleteAll, count Students: " + studentDao.findAll().size());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
