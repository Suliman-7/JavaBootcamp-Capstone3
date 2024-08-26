package com.example.capstone3.Repository;

import com.example.capstone3.Model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptainRepository extends JpaRepository<Captain,Integer> {

    Captain findCaptainById(Integer id);
}
