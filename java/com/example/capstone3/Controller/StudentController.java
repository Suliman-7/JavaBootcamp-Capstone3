package com.example.capstone3.Controller;

import com.example.capstone3.Model.RequestRide;
import com.example.capstone3.Model.Student;
import com.example.capstone3.Service.ReviewService;
import com.example.capstone3.Service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")

public class StudentController {

    private final StudentService studentService;
    private final ReviewService reviewService;

    @GetMapping("/get")
    public ResponseEntity findAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/post")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted successfully");
    }

    @PutMapping("{sid}/subscribe/{cid}/{period}")
    public ResponseEntity subscribeStudent(@PathVariable int sid, @PathVariable int cid, @PathVariable @Min(value = 1) @Max(value = 3) int period) {
        studentService.subscribeStudent(sid, cid, period);
        return ResponseEntity.status(200).body("Student subscribed successfully");
    }

    @PutMapping("{sid}/join/{dtid}")
    public ResponseEntity joinStudent(@PathVariable int sid, @PathVariable int dtid) {
        studentService.joinDailyTrip(sid,dtid);
        return ResponseEntity.status(200).body("Student joined daily trip successfully");
    }

    @PutMapping("{sid}/joindeliverygroup/{dgid}")
    public ResponseEntity joinDeliveryGroup(@PathVariable int sid, @PathVariable int dgid) {
        studentService.joinFacilityDelivery(sid,dgid);
        return ResponseEntity.status(200).body("Student joined to delivery group successfully");
    }

    @PutMapping("{sid}/review/{cid}/{comment}/{rate}")
    public ResponseEntity addReview(@PathVariable int sid, @PathVariable int cid, @PathVariable String comment ,  @PathVariable @Min(value = 1) @Max(value = 5) int rate) {
        studentService.addCaptainReview(sid,cid,comment,rate);
        return ResponseEntity.status(200).body("Review added successfully");
    }

    @GetMapping("/showreviews/{sid}")
    public ResponseEntity showReviews(@PathVariable int sid) {
        studentService.showStudentReviews(sid);
        return ResponseEntity.status(200).body("Show reviews successfully");
    }


    @GetMapping("/students-report")
    public ResponseEntity studentReport(){
        return ResponseEntity.status(200).body(studentService.studentReport());
    }

    @GetMapping("/find-student-by-academic-level/{academicLevel}")
    public ResponseEntity findStudentByAcademicLevel(@PathVariable String academicLevel)
    {
        return ResponseEntity.status(200).body(studentService.findStudentByAcademicLevel(academicLevel));
    }
    @GetMapping("/find-student-by-gender/{gender}")
    public ResponseEntity findStudentByGender(@PathVariable String gender)
    {
        return ResponseEntity.status(200).body(studentService.findStudentByGender(gender));
    }

    @PutMapping("/request-ride/{studentid}")
    public ResponseEntity requestRideStudent(@PathVariable int studentid,@Valid @RequestBody RequestRide rd) {
        studentService.requestRide(studentid,rd);
        return ResponseEntity.status(200).body("Student requested successfully");
    }


    @DeleteMapping("/cancel-request/{studentid}")
    public ResponseEntity cancelRequestStudent(@PathVariable int studentid) {
        studentService.cancelRequest(studentid);
        return ResponseEntity.status(200).body("Student request cancelled successfully");
    }



}
