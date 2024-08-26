package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Captain;
import com.example.capstone3.Repository.CaptainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CaptainService {

    private CaptainRepository captainRepository;

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
}