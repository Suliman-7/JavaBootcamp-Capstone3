package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.*;
import com.example.capstone3.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final CaptainRepository captainRepository;
    private final DailyTripRepository dailyTripRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ReviewRepository reviewRepository;
    private final FacilityDeliveryGroupRepository facilityDeliveryGroupRepository;
    private final RequestRideRepository requestRideRepository;
    private final FacilityRepository facilityRepository;

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


        stu.setSubscription(subscription);
        subscription.setStudent(stu);
        studentRepository.save(stu);
        subscriptionRepository.save(subscription);

    }

    public void joinDailyTrip(int studentId , int dailyTripId){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }
        DailyTrip dailyTrip = dailyTripRepository.findDailyTripById(dailyTripId);
        if(dailyTrip == null){
            throw new ApiException("daily trip not found");
        }

        stu.setDailyTrip(dailyTrip);
        dailyTrip.getStudents().add(stu);
        studentRepository.save(stu);
        dailyTripRepository.save(dailyTrip);
    }

    public void joinFacilityDelivery(int studentId , int fdId){
        //check
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }

        FacilityDeliveryGroup delgrp = facilityDeliveryGroupRepository.findFacilityDeliveryGroupById(fdId);
        if(delgrp == null){
            throw new ApiException("facility delivery group not found");
        }

        stu.setDeliveryGroup(delgrp);
        delgrp.getStudents().add(stu);
        delgrp.setJoinedStudents(delgrp.getJoinedStudents()+1);
        studentRepository.save(stu);
        facilityDeliveryGroupRepository.save(delgrp);
    }

    public void addCaptainReview(int studentId , int captainId , String comment , int rate ){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }
        Captain cap = captainRepository.findCaptainById(captainId);
        if(cap == null){
            throw new ApiException("captain not found");
        }

        if(stu.getCaptain() != cap){
            throw new ApiException("captain doesn't match");
        }

        for(Review review : reviewRepository.findAll()){
            if(review.getStudent() == stu){
                throw new ApiException("you already reviewed");
            }
        }

        if(cap.getRate()==0){
            cap.setRate(rate);
            captainRepository.save(cap);
        }
        else {
            cap.setRate((cap.getRate() + rate) / 2);
            captainRepository.save(cap);

        }

        Review review = new Review();
        review.setComment(comment);
        review.setRate(rate);
        review.setStudent(stu);
        review.setCaptain(cap);
        stu.getReviews().add(review);
        cap.getReviews().add(review);
        studentRepository.save(stu);
        reviewRepository.save(review);
        captainRepository.save(cap);

    }

    public Set<Review> showStudentReviews(int studentId){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }

        if(stu.getReviews().isEmpty()){
            throw new ApiException("student does not have any reviews");
        }
        return stu.getReviews();
    }


    //student apply request for ride
    public void requestRide(int studentId , RequestRide requestRide){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }

        RequestRide rd = new RequestRide();
        rd.setStartPoint(requestRide.getStartPoint());
        rd.setLeaveHour(requestRide.getLeaveHour());
        rd.setDestination(requestRide.getDestination());
        rd.setStudent(stu);
        requestRideRepository.save(rd);
        stu.setRequestRide(rd);
        studentRepository.save(stu);
    }

    //student cancel request
    public void cancelRequest(int studentId){
        Student stu = studentRepository.findStudentById(studentId);
        if(stu == null){
            throw new ApiException("student not found");
        }
        RequestRide rd = requestRideRepository.findRequestRideById(stu.getId());
        if (rd == null){
            throw new ApiException("requestRide not found");
        }
        rd.setStudent(null);
        requestRideRepository.deleteById(stu.getRequestRide().getId());
    }


    public List<Student> findStudentByAcademicLevel(String academicLevel)
    {
        if(studentRepository.findStudentByAcademicLevel(academicLevel).isEmpty())
        {
            throw new ApiException("It is empty");
        }
        return studentRepository.findStudentByAcademicLevel(academicLevel);
    }


    public List<Student> findStudentByGender(String gender)
    {
        if(studentRepository.findStudentByGender(gender).isEmpty())
        {
            throw new ApiException("It is null");
        }
        return studentRepository.findStudentByGender(gender);
    }


    // Abdulaziz
    public List<String> studentReport(){
        ArrayList<String> report = new ArrayList<>();
        for (Student student : studentRepository.findAll()){
            report.add("=================");
            report.add("Student name: "+student.getName());
            report.add("Student age: "+student.getAge());
            report.add("phone number: "+student.getPhoneNumber());
            report.add("student academic level: "+student.getAcademicLevel());
            report.add("disable "+student.isDisable());
            report.add("Gender: "+student.getGender());
            report.add("address: "+student.getAddress());
        }
        return report;
    }

}
