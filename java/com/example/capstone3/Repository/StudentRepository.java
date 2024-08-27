package com.example.capstone3.Repository;

import com.example.capstone3.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(int id);

    List<Student> findStudentByAcademicLevel(String academicLevel);

    List<Student> findStudentByGender(String gender);
}
