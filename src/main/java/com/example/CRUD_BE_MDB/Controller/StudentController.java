package com.example.CRUD_BE_MDB.Controller;
import com.example.CRUD_BE_MDB.Model.Student;
import com.example.CRUD_BE_MDB.Service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/api/students"})
public class StudentController {
 @Autowired
 private StudentService studentService;
 public StudentController() {
 }
 @PostMapping
 public ResponseEntity<Student> createStudent(@RequestBody Student
student) {
 Student createdStudent =
this.studentService.createStudent(student);
 return ResponseEntity.ok(createdStudent);
 }
 @GetMapping({"/{id}"})
 public ResponseEntity<Student> getStudentById(@PathVariable long id) {
 Student student = this.studentService.getStudentById(id);
 return student != null ? ResponseEntity.ok(student) :
ResponseEntity.notFound().build();
 }
 @GetMapping
 public ResponseEntity<List<Student>> getAllStudents() {
 List<Student> students = this.studentService.getAllStudents();
 return ResponseEntity.ok(students);
 }
 @PutMapping({"/{id}"})
 public ResponseEntity<Student> updateStudent(@PathVariable long id,
@RequestBody Student student) {
 Student updatedStudent = this.studentService.updateStudent(id,
student);
 return updatedStudent != null ? ResponseEntity.ok(updatedStudent) :
ResponseEntity.notFound().build();
 }
 @DeleteMapping({"/{id}"})
 public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
 this.studentService.deleteStudent(id);
 return ResponseEntity.noContent().build();
 }
}