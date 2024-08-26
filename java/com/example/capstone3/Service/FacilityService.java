package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Facility;
import com.example.capstone3.Repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;

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
            throw new ApiException("not found");
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
             throw new ApiException("not found");
        }
        facilityRepository.deleteById(id);
    }
}
