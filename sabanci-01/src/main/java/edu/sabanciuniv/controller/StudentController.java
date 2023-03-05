package edu.sabanciuniv.controller;

import edu.sabanciuniv.service.StudentService;
import edu.sabanciuniv.model.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {


    public StudentService service = new StudentService();

    @GetMapping("")
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Long id) {
        return service.findStudentById(id);
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }


}
