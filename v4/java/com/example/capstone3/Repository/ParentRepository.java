package com.example.capstone3.Repository;

import com.example.capstone3.Model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    Parent findParentById(int id);
}
