package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Captain;
import com.example.capstone3.Model.Student;
import com.example.capstone3.Model.Subscription;
import com.example.capstone3.Repository.CaptainRepository;
import com.example.capstone3.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final CaptainRepository captainRepository;

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
        studentRepository.save(stu);
    }

    public void deleteStudent(int id){
        Student stu = studentRepository.findStudentById(id);
        if(stu == null){
            throw new ApiException("student not found");
        }
        studentRepository.delete(stu);
    }


    public void subscribeStudent(int studentId , int period , int captainId ){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }
        Captain cap = captainRepository.findCaptainById(captainId);
        if(cap == null){
            throw new ApiException("captain not found");
        }
        Subscription subscription = new Subscription();

        subscription.setCaptain(cap);
        subscription.setPeriod(period);
        subscription.setStudent(stu);

        if(period == 1){
            subscription.setPrice(149);
        }
        if(period == 3){
            subscription.setPrice(399);
        }
        if(period == 6){
            subscription.setPrice(599);
        }

    }
}
