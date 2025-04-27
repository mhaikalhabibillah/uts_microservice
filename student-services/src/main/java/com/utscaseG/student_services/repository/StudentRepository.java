package com.utscaseG.student_services.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utscaseG.student_services.model.Student;


@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {

   
}
