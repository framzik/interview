package ru.khrebtov.hw7.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.khrebtov.hw7.entity.Student;
import ru.khrebtov.hw7.service.StudentService;


@Controller
@RequestMapping(path = "/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String  findAll(Model model) {
        logger.info("Student list page requested");
        model.addAttribute("students", studentService.getStudents());

        return  "student";
    }

    @GetMapping("/new")
    public String newStudentsForm(Model model) {
        logger.info("New students page requested");
        model.addAttribute("student", new Student());

        return "student_new";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        logger.info("Edit student page requested");
        model.addAttribute("student", studentService.findById(id));

        return "student_new";
    }

    @PostMapping
    public String update(Student student) {
        logger.info("Saving student");

        studentService.save(student);

        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        logger.info("Deleting student");
        studentService.deleteById(id);

        return "redirect:/students";
    }
}
