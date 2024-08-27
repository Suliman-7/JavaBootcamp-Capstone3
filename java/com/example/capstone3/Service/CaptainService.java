package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.*;
import com.example.capstone3.Repository.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CaptainService {

    private final DailyTripRepository dailyTripRepository;
    private final FacilityDeliveryGroupRepository facilityDeliveryGroupRepository;
    private final StudentRepository studentRepository;
    private final CaptainRepository captainRepository;
    private final RequestRideRepository requestRideRepository;

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    public void addCaptain(Captain captain) {
        captainRepository.save(captain);
    }

    public void deleteCaptain(int captain_id) {
        Captain captain = captainRepository.findCaptainById(captain_id);

        if (captain == null){
            throw new ApiException("Captain not found");
        }
        captainRepository.delete(captain);

    }

    public void updateCaptain(int captain_id, Captain captain) {
        Captain captain1 = captainRepository.findCaptainById(captain_id);
        if (captain1 == null){
            throw new ApiException("Captain not found");
        }
        captain1.setName(captain.getName());
        captain1.setAge(captain.getAge());
        captain1.setPhoneNumber(captain.getPhoneNumber());
        captain1.setVehicle(captain.getVehicle());
        captain1.setLicensed(captain.isLicensed());
        captainRepository.save(captain1);
    }

    public void publishDailyTrip(int captainId, DailyTrip dailyTrip) {
        Captain captain = captainRepository.findCaptainById(captainId);
        if (captain == null){
            throw new ApiException("Captain not found");
        }
        dailyTrip.setCaptain(captain);
        captain.getDailyTrips().add(dailyTrip);
        captainRepository.save(captain);
        dailyTripRepository.save(dailyTrip);
    }

    public void applyDeliveryGroup (int captainId, int delgrpId) {
        //check
        Captain captain = captainRepository.findCaptainById(captainId);
        if (captain == null){
            throw new ApiException("Captain not found");
        }
        FacilityDeliveryGroup facdelgrp = facilityDeliveryGroupRepository.findFacilityDeliveryGroupById(delgrpId);
        if (facdelgrp == null){
            throw new ApiException("FacilityDeliveryGroup not found");
        }


        facdelgrp.setCaptain(captain);
        captain.setDeliveryGroup(facdelgrp);
        facilityDeliveryGroupRepository.save(facdelgrp);
        captainRepository.save(captain);
    }

    public Set<Review> showCaptainReviews(int captain_id) {
        Captain captain = captainRepository.findCaptainById(captain_id);
        if (captain == null){
            throw new ApiException("Captain not found");
        }
        if (captain.getReviews().isEmpty()){
            throw new ApiException("No reviews found");
        }
        return captain.getReviews();
    }

    public List<Captain> showHighestCaptainsReview() {


        List<Captain> highestRev = captainRepository.findAll();

        for (int i = 0; i < highestRev.size() - 1; i++) {
            for (int j = 0; j < highestRev.size() - i - 1; j++) {
                if (highestRev.get(j).getRate() > highestRev.get(j + 1).getRate()) {
                    Captain temp = highestRev.get(j);
                    highestRev.set(j, highestRev.get(j + 1));
                    highestRev.set(j + 1, temp);
                }
            }
        }
        return highestRev;

    }

    public List report() {
        List<String> report = new ArrayList<>();
        for (Captain captain : captainRepository.findAll()) {


            report.add("------------------------------------");
            report.add("Captain name : " + captain.getName());
            report.add("Captain Vehicle : " + captain.getVehicle());
            report.add("Captain age  : " + captain.getAge());
            report.add("Captain phone number : " + captain.getPhoneNumber());
            report.add("Captain rate  : " + captain.getRate());

        }

        return report;

    }

    //display student request rides
    public List<RequestRide> displayRequestRides() {
        return requestRideRepository.findAll();
    }

    //captain approved for student request ride
    public void ApproveRequestRide(int captain_id,int request_id) {
        Captain captain = captainRepository.findCaptainById(captain_id);
        if (captain == null){
            throw new ApiException("Captain not found");
        }
        RequestRide requestRide = requestRideRepository.findRequestRideById(request_id);
        if (requestRide == null){
            throw new ApiException("RequestRide not found");
        }
        captain.setRequestRide(requestRide);
        requestRide.setCaptain(captain);
        requestRideRepository.save(requestRide);
        captainRepository.save(captain);
    }

    public List<Captain> findCaptainByVehicle(String vehicle)
    {
        if(captainRepository.findCaptainByVehicle(vehicle).isEmpty())
        {
            throw new ApiException("Captain not found");
        }
        return captainRepository.findCaptainByVehicle(vehicle);
    }

}