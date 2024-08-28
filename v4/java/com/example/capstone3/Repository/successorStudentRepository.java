package com.example.capstone3.Repository;

import com.example.capstone3.Model.SuccessorStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface successorStudentRepository extends JpaRepository<SuccessorStudent, Integer> {

    SuccessorStudent findById(int id);
}
