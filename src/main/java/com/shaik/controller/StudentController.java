package com.shaik.controller;

import com.shaik.model.Student;
import com.shaik.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudentById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student deleted successfully.");
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Map<String, String>> updateStudent(@PathVariable Integer id, @RequestBody Student student) {

        studentService.updateStudent(id, student);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student updated successfully.");
        return ResponseEntity.ok(response);
    }
}
