package com.example.capstone3.Repository;

import com.example.capstone3.Model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Integer> {
    public Captain findCaptainById(int id);
}