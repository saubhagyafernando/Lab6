package com.example.CRUD_BE_MDB.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CRUD_BE_MDB.Service.StudentService;
import com.example.CRUD_BE_MDB.Repository.StudentRepository;

import com.example.CRUD_BE_MDB.Model.Student;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Student student, String id) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName()); // Corrected method call
        existingStudent.setLastName(student.getLastName()); // Corrected method call
        existingStudent.setEmail(student.getEmail()); // Corrected method call
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}