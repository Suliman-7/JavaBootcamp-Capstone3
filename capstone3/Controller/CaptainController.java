package com.example.capstone3.Controller;

import com.example.capstone3.Model.Captain;
import com.example.capstone3.Service.CaptainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/captain")
public class CaptainController {
    private final CaptainService captainService;

    @GetMapping("/get")
    public ResponseEntity getAllCaptaines() {
        return ResponseEntity.status(200).body(captainService.getAllCaptains());
    }

    @PostMapping("/add")
    public ResponseEntity addCaptain(@Valid @RequestBody Captain captain) {
        captainService.addCaptain(captain);
        return ResponseEntity.status(200).body("Captain added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCaptain(@PathVariable int id) {
        captainService.deleteCaptain(id);
        return ResponseEntity.status(200).body("Captain deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCaptain(@PathVariable int id,@Valid @RequestBody Captain captain) {
        captainService.updateCaptain(id,captain);
        return ResponseEntity.status(200).body("Captain updated successfully");
    }

}