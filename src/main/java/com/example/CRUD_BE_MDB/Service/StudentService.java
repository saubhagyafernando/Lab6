package com.example.CRUD_BE_MDB.Service;
import com.example.CRUD_BE_MDB.Model.Student;
import java.util.List;
public interface StudentService {
 Student saveStudent(Student student);
 Student createStudent(Student student);
 Student getStudentById(String id);
 List<Student> getAllStudents();
 Student updateStudent(String id, Student student);
 void deleteStudent(String id);
}