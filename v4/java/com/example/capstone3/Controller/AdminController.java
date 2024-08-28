package com.example.capstone3.Controller;

import com.example.capstone3.Model.Admin;
import com.example.capstone3.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")

public class AdminController {

    private final AdminService adminService;

    @GetMapping("/get")
    public ResponseEntity getAllAdmin() {
        return ResponseEntity.status(200).body(adminService.getAllAdmins());
    }

    @PostMapping("/post")
    public ResponseEntity addAdmin(@Valid @RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return ResponseEntity.status(200).body("admin successfully added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmin(@PathVariable int id, @Valid @RequestBody Admin admin) {
        adminService.updateAdmin(id, admin);
        return ResponseEntity.status(200).body("admin successfully updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.status(200).body("admin successfully deleted");
    }


    @GetMapping("/display-reports")
    public ResponseEntity displayReports() {
        return ResponseEntity.status(200).body(adminService.displayAllReports());
    }

    @PutMapping("/warn-captain/{captainid}")
    public ResponseEntity warnCaptain(@PathVariable int captainid) {
        adminService.makeWarnToCaptain(captainid);
        return ResponseEntity.status(200).body("captain warned successfully");
    }
}
