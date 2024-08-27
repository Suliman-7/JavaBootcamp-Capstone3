package com.example.capstone3.Repository;

import com.example.capstone3.Model.FacilityDeliveryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityDeliveryGroupRepository extends JpaRepository<FacilityDeliveryGroup, Integer> {

    FacilityDeliveryGroup findFacilityDeliveryGroupById(int id);
}
