package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Captain;
import com.example.capstone3.Model.Facility;
import com.example.capstone3.Model.FacilityDeliveryGroup;
import com.example.capstone3.Repository.CaptainRepository;
import com.example.capstone3.Repository.FacilityDeliveryGroupRepository;
import com.example.capstone3.Repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final CaptainRepository captainRepository;
    private final FacilityDeliveryGroupRepository facilityDeliveryGroupRepository;

    public List<Facility> getFacilities()
    {
        return facilityRepository.findAll();
    }
    public void addFacility(Facility facility)
    {
        facilityRepository.save(facility);
    }
    public void updateFacility(Integer id,Facility facility)
    {
        Facility f = facilityRepository.findFacilityById(id);
        if(f == null)
        {
            throw new ApiException("Facility not found");
        }
        f.setName(facility.getName());
        f.setType(facility.getType());
        f.setCity(facility.getCity());
        f.setAddress(facility.getAddress());
        facilityRepository.save(f);
    }

    public void deleteFacility(Integer id)
    {
        if(facilityRepository.findFacilityById(id) == null)
        {
             throw new ApiException("Facility not found");
        }
        facilityRepository.deleteById(id);
    }

    public void createFacilityDeliveryGroup(int facilityId , FacilityDeliveryGroup facdelgrp){
        // check
        Facility facility = facilityRepository.findFacilityById(facilityId);
        if(facility == null){
            throw new ApiException("Facility not found");
        }

        facility.setDeliveryGroup(facdelgrp);
        facdelgrp.setFacility(facility);
        facilityDeliveryGroupRepository.save(facdelgrp);
        facilityRepository.save(facility);

    }

    public List<Facility> findFacilityByCity(String city)
    {
        if(facilityRepository.findFacilityByCity(city).isEmpty())
        {
            throw new ApiException("Facility not found");
        }
        return facilityRepository.findFacilityByCity(city);
    }
}