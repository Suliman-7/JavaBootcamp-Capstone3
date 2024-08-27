package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.DailyTrip;
import com.example.capstone3.Model.RequestRide;
import com.example.capstone3.Repository.RequestRideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RequestRideService {

    private final RequestRideRepository requestRideRepository;

    public List<RequestRide> getAllRequestRides() {
        return requestRideRepository.findAll();
    }

    public List<RequestRide> getRequestRideByDestination(String destination) {
        List<RequestRide> byDestination = new ArrayList<>();
        for(RequestRide rr : requestRideRepository.findAll()) {
            if(rr.getDestination().equals(destination)) {
                byDestination.add(rr);
            }
        }
        if(byDestination.isEmpty()) {
            throw new ApiException("there is no request ride going to this destination");
        }
        return byDestination;
    }
}
