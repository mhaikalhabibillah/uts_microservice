package com.utscaseG.homework_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utscaseG.homework_service.model.Homework;


@Repository

public interface HomeworkRepository extends JpaRepository<Homework, Long> {

   
    
}
