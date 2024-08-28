package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.DTO.ParentRequestRideDTO;
import com.example.capstone3.Model.*;
import com.example.capstone3.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParentService {

    private final StudentRepository studentRepository;
    private final FacilityRepository facilityRepository;
    private final com.example.capstone3.Repository.successorStudentRepository successorStudentRepository;
    private final DailyTripRepository dailyTripRepository;
    private ParentRepository parentRepository;
    private ParentRequestRideRepository parentRequestRideRepository;


    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public void addParent(Parent parent) {
        parentRepository.save(parent);
    }

    public void updateParent(int parentID,Parent parent) {
        Parent p = parentRepository.findParentById(parentID);

        if (p == null){
            throw new ApiException("parent not found");
        }

        p.setName(parent.getName());
        p.setPhoneNumber(parent.getPhoneNumber());
        p.setEmail(parent.getEmail());
        parentRepository.save(p);
    }

    public void deleteParent(int parentID) {
        Parent p = parentRepository.findParentById(parentID);
        if (p == null){
            throw new ApiException("parent not found");
        }
        parentRepository.delete(p);
    }

    public void addStudentToParent(int parentID, SuccessorStudent successorStudent) {
        Parent p = parentRepository.findParentById(parentID);
        if (p == null){
            throw new ApiException("parent not found");
        }
        Facility f = facilityRepository.findFacilityById(successorStudent.getSchoolId());
        if (f == null){
            throw new ApiException("School not found");
        }

        p.getSuccessorStudents().add(successorStudent);
        successorStudent.setParent(p);
        successorStudentRepository.save(successorStudent);
    }

    public void addRequestRideByParent(int parentId , ParentRequestRideDTO parentrequestRideDTO){
        Parent p = parentRepository.findParentById(parentId);

        if(p == null){
            throw new ApiException("parent not found");
        }

        if (p.getSuccessorStudents().isEmpty()){
            throw new ApiException("parent does not have any Successor student");
        }
        if(parentrequestRideDTO.getPeriod() == 1){
            parentrequestRideDTO.setPrice(149);
        }
        if(parentrequestRideDTO.getPeriod() == 2){
            parentrequestRideDTO.setPrice(249);
        }
        if(parentrequestRideDTO.getPeriod() == 3){
            parentrequestRideDTO.setPrice(349);
        }

        ParentRequestRide prd = new ParentRequestRide(p.getId()
                ,p.getName()
                ,parentrequestRideDTO.getStartPoint(),parentrequestRideDTO.getLeaveHour(),
                parentrequestRideDTO.getPeriod(),parentrequestRideDTO.getPrice(),p,null);

        parentRequestRideRepository.save(prd);
        p.setParentRequestRide(prd);
        parentRepository.save(p);
    }

    public List<DailyTrip> displayCaptainsTrip(){
        return dailyTripRepository.findAll();
    }

    public void joinDailyTrip(int successorStudentId , int dailyTripId){
        SuccessorStudent sc = successorStudentRepository.findById(successorStudentId);
        if(sc == null){
            throw new ApiException("Successor not found");
        }
        DailyTrip dailyTrip = dailyTripRepository.findDailyTripById(dailyTripId);
        if(dailyTrip == null){
            throw new ApiException("daily trip not found");
        }

        for(SuccessorStudent successorStudent : dailyTrip.getSuccessors()){
            if(successorStudent.getId() == successorStudent.getId()){
                throw new ApiException("you are already registered to this delivery group");
            }
        }

        sc.setDailyTrip(dailyTrip);
        dailyTrip.getSuccessors().add(sc);
        successorStudentRepository.save(sc);
        dailyTripRepository.save(dailyTrip);
    }
}
