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

    @GetMapping("/get-all-captaines")
    public ResponseEntity getAllCaptaines() {
        return ResponseEntity.status(200).body(captainService.getAllCaptains());
    }

    @PostMapping("/add-captain")
    public ResponseEntity addCaptain(@Valid @RequestBody Captain captain) {
        captainService.addCaptain(captain);
        return ResponseEntity.status(200).body("Captain added successfully");
    }

    @DeleteMapping("/delete-captain/{captainid}")
    public ResponseEntity deleteCaptain(@PathVariable int captainid) {
        captainService.deleteCaptain(captainid);
        return ResponseEntity.status(200).body("Captain deleted successfully");
    }

    @PutMapping("/update-captain/{captainid}")
    public ResponseEntity updateCaptain(@PathVariable int captainid,@Valid @RequestBody Captain captain) {
        captainService.updateCaptain(captainid,captain);
        return ResponseEntity.status(200).body("Captain updated successfully");
    }
}
