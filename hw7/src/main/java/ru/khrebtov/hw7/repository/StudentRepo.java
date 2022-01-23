package ru.khrebtov.hw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khrebtov.hw7.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
