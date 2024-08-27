package com.example.capstone3.Controller;

import com.example.capstone3.Model.DailyTrip;
import com.example.capstone3.Service.DailyTripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trip")


public class DailyTripController {


    private final DailyTripService dailyTripService;

    @GetMapping("/get")
    public ResponseEntity getAllTrips() {
        return ResponseEntity.status(200).body(dailyTripService.getAllDailyTrips());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTrip(@PathVariable int id, @Valid @RequestBody DailyTrip dailyTrip) {
        dailyTripService.updateDailyTrip(id, dailyTrip);
        return ResponseEntity.status(200).body("Daily Trip updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrip(@PathVariable int id) {
        dailyTripService.deleteDailyTrip(id);
        return ResponseEntity.status(200).body("Daily Trip deleted successfully");
    }
}
