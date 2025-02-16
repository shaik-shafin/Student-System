package com.shaik.service;

import com.shaik.model.Student;
import com.shaik.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(Integer id){
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student updateStudent = getStudentById(id, student);
        studentRepository.save(updateStudent);
        return updateStudent;
    }

    private Student getStudentById(Integer id, Student student) {
        Student dbStudent = studentRepository.findById(id).get();
        dbStudent.setName(student.getName());
        dbStudent.setEmail(student.getEmail());
        return dbStudent;
    }
}
