//package com.example.capstone3.Controller;
//
//
//import com.example.capstone3.Service.SubscriptionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/subscribe")
//public class SubscriptionController {
//
//    private final SubscriptionService subscriptionService;
//
//    @GetMapping("/get")
//    public ResponseEntity getAllSubscribed() {
//        return ResponseEntity.status(200).body(subscriptionService.getAllSubscribe());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteSubscribed(@PathVariable Integer id) {
//        subscriptionService.deleteSubscribe(id);
//        return ResponseEntity.status(200).body("Subscribe deleted successfully");
//    }
//}
