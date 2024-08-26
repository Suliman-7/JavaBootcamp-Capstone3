package com.example.capstone3.Repository;

import com.example.capstone3.Model.DailyTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DailyTripRepository extends JpaRepository<DailyTrip, Integer> {

    DailyTrip findDailyTripById(int id);
}
