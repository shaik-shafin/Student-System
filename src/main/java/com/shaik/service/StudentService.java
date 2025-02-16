package com.shaik.service;

import com.shaik.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> getAllStudents();

    void deleteStudentById(Integer id);

    Student updateStudent(Integer id, Student student);
}
