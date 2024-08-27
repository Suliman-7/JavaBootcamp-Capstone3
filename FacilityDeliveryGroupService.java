package com.example.capstone3.Service;


import com.example.capstone3.Model.FacilityDeliveryGroup;
import com.example.capstone3.Repository.FacilityDeliveryGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class FacilityDeliveryGroupService {

    private final FacilityDeliveryGroupRepository facilityDeliveryGroupRepository;

    public List<FacilityDeliveryGroup> getAllFacilityDeliveryGroup(){
        return facilityDeliveryGroupRepository.findAll();
    }


}

