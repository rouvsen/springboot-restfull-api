package com.rouvsen.student.controller;

import com.rouvsen.student.model.Student;
import com.rouvsen.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //READ
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //CREATE
    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //DELETE
    @DeleteMapping(path = "{studentId}")
    public void addNewStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    //UPDATE
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ){
        studentService.updateStudent(studentId, name, email);
    }
}
