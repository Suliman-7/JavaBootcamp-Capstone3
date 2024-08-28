package com.example.capstone3.Repository;

import com.example.capstone3.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    Complaint findReportById(int id);

    Complaint findReportByCapId(int capId);
}
