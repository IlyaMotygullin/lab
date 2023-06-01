package ru.lern.lab.controller;

import org.springframework.web.bind.annotation.*;
import ru.lern.lab.Service.StudentService;
import ru.lern.lab.View.StudentView;

import java.util.List;

@RestController()
public class StudentController {
    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentView studentView){
        studentService.addStudent(studentView);
    }
    @GetMapping("/student/{id}")
    public StudentView getStudentById(@PathVariable(name = "id") Long id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/all")
    public List<StudentView> getAllStudent(){
        return studentService.getAllStudent();
    }
}
