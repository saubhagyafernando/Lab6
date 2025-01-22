package com.example.CRUD_BE_MDB.Repository;

import com.example.CRUD_BE_MDB.Model.Student;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepository extends MongoRepository<String, Student> {

    // Find student by year of enrollment
    List<Student> findByYearOfEnrollment(int year);

    // Find student by year department
    List<Student> findByDepartment(String department);

    // use @Query annoation for custom MongoDB queries
    @Query("{'email':?0}")
    Student findByEmail(String email);

    @Query("{'department': ?0, 'yearOfEnrollment': ?1}")
    List<Student> findByDepartmentAndYearOfEnrollment(String department, int year);
}