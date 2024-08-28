package com.example.capstone3.Controller;

import com.example.capstone3.Service.RequestRideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requestride")

public class RequestRideController {

    private final RequestRideService requestRideService;

    @GetMapping("/get")
    public ResponseEntity getAllRequestRide(){
        return ResponseEntity.status(200).body(requestRideService.getAllRequestRides());
    }

    @GetMapping("/bydestination/{destination}")
    public ResponseEntity getAllRequestRideByDestination(@PathVariable String destination) {
        return ResponseEntity.status(200).body(requestRideService.getRequestRideByDestination(destination));
    }
}
