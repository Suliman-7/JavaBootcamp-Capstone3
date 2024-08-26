package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Student;
import com.example.capstone3.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(int id , Student student){
        Student stu = studentRepository.findStudentById(id);

        if(stu == null){
            throw new ApiException("student not found");
        }
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setAddress(student.getAddress());
        stu.setAcademicLevel(student.getAcademicLevel());
        stu.setDisable(student.isDisable());
        stu.setFacilityId(student.getFacilityId());
        studentRepository.save(stu);
    }

    public void deleteStudent(int id){
        Student stu = studentRepository.findStudentById(id);
        if(stu == null){
            throw new ApiException("student not found");
        }
        studentRepository.delete(stu);
    }
}
