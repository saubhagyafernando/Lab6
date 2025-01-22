package com.example.CRUD_BE_MDB.Service;

import com.example.CRUD_BE_MDB.Model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(String student);

    Student createStudent(String student);

    Student getStudentById(String id);

    List<Student> getAllStudents();

    Student updateStudent(long id, Student student);

    void deleteStudent(String id);
}