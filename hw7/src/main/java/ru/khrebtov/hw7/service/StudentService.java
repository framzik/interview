package ru.khrebtov.hw7.service;

import org.springframework.stereotype.Service;
import ru.khrebtov.hw7.entity.Student;
import ru.khrebtov.hw7.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }
}
