package com.example.capstone3.Repository;

import com.example.capstone3.Model.RequestRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRideRepository extends JpaRepository<RequestRide, Integer> {

    public RequestRide findRequestRideById(int id);
}