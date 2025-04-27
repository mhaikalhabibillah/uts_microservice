package com.utscaseG.teacher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utscaseG.teacher_service.model.Teacher;


@Repository

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

   
    
}
