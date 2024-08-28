package com.example.capstone3.Repository;

import com.example.capstone3.Model.ParentRequestRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRequestRideRepository extends JpaRepository<ParentRequestRide, Integer> {

    ParentRequestRideRepository findParentRequestRideById(int id);
}
