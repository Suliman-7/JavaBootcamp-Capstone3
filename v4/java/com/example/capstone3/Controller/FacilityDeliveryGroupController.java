package com.example.capstone3.Controller;

import com.example.capstone3.Model.FacilityDeliveryGroup;
import com.example.capstone3.Service.FacilityDeliveryGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliverygroup")


public class FacilityDeliveryGroupController {

    private final FacilityDeliveryGroupService facilityDeliveryGroupService;

    @GetMapping("/get")
    public ResponseEntity getAllFacilityDeliveryGroups() {
        return ResponseEntity.status(200).body(facilityDeliveryGroupService.getAllFacilityDeliveryGroup());
    }






}
