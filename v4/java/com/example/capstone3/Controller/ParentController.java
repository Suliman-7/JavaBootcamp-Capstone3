package com.example.capstone3.Controller;

import com.example.capstone3.DTO.ParentRequestRideDTO;
import com.example.capstone3.Model.Parent;
import com.example.capstone3.Model.Student;
import com.example.capstone3.Model.SuccessorStudent;
import com.example.capstone3.Service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/parent")
public class ParentController {
    private final ParentService parentService;

    @GetMapping("/get-all-parents")
    public ResponseEntity getAllParents() {
        return ResponseEntity.ok(parentService.getAllParents());
    }

    @PostMapping("/add-parent")
    public ResponseEntity addParent(@Valid @RequestBody Parent parent) {
        parentService.addParent(parent);
        return ResponseEntity.status(200).body("parent added successfully");
    }

    @PutMapping("/update-parent/{parentid}")
    public ResponseEntity updateParent(@PathVariable int parentid, @Valid @RequestBody Parent parent) {
        parentService.updateParent(parentid, parent);
        return ResponseEntity.status(200).body("parent updated successfully");
    }

    @DeleteMapping("/delete-parent/{parentid}")
    public ResponseEntity deleteParent(@PathVariable int parentid) {
        parentService.deleteParent(parentid);
        return ResponseEntity.status(200).body("parent deleted successfully");
    }

    @PutMapping("/add-student-to-parent/{parentid}")
    public ResponseEntity addStudentToParent(@PathVariable int parentid, @RequestBody SuccessorStudent successorStudent) {
        parentService.addStudentToParent(parentid, successorStudent);
        return ResponseEntity.status(200).body("student added successfully");
    }

    @PutMapping("/parent-request-ride/{parentid}")
    public ResponseEntity parentRequestRide(@PathVariable int parentid,@Valid @RequestBody ParentRequestRideDTO parentRequestRideDTO) {
        parentService.addRequestRideByParent(parentid, parentRequestRideDTO);
        return ResponseEntity.status(200).body("request added successfully");
    }


    @GetMapping("/show-all-trips")
    public ResponseEntity showAllTrips() {
        return ResponseEntity.status(200).body(parentService.displayCaptainsTrip());
    }

    @PutMapping("/{sid}/join/{dtid}")
    public ResponseEntity studentJoinTrip(@PathVariable int sid, @PathVariable int dtid) {
        parentService.joinDailyTrip(sid,dtid);
        return ResponseEntity.status(200).body("Student joined daily trip successfully");
    }

}
