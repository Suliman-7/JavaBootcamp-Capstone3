package com.example.capstone3.Service;


import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.DailyTrip;
import com.example.capstone3.Repository.DailyTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class DailyTripService {

    private final DailyTripRepository dailyTripRepository;

    public List<DailyTrip> getAllDailyTrips() {
        return dailyTripRepository.findAll();
    }


    public void updateDailyTrip(int id , DailyTrip dailyTrip) {
        DailyTrip dt = dailyTripRepository.findDailyTripById(id);
        if(dt == null) {
            throw new ApiException("trip not found");
        }
        dt.setDestination(dailyTrip.getDestination());
        dt.setPrice(dailyTrip.getPrice());
        dt.setLeaveHour(dailyTrip.getLeaveHour());
        dt.setStartPoint(dailyTrip.getStartPoint());
        dailyTripRepository.save(dt);
    }

    public void deleteDailyTrip(int id) {
        DailyTrip dt = dailyTripRepository.findDailyTripById(id);
        if(dt == null) {
            throw new ApiException("trip not found");
        }
        dailyTripRepository.delete(dt);
    }


    public List<DailyTrip> getDailyTripsByDestination(String destination) {
        List<DailyTrip> byDestination = new ArrayList<>();
        for(DailyTrip dt : dailyTripRepository.findAll()) {
            if(dt.getDestination().equals(destination)) {
                byDestination.add(dt);
            }
        }
        if(byDestination.isEmpty()) {
            throw new ApiException("there is no daily trip going to this destination");
        }
        return byDestination;
    }


}
