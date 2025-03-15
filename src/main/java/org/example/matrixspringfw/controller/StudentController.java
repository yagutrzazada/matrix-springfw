package org.example.matrixspringfw.controller;

import lombok.RequiredArgsConstructor;
import org.example.matrixspringfw.model.StudentDto;
import org.example.matrixspringfw.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    public final StudentService studentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDto studentDto){
        studentService.createStudent(studentDto);
    }
    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public void DeleteStudentByID(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
