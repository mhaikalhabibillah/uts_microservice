package com.utscaseG.teacher_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utscaseG.teacher_service.model.Teacher;
import com.utscaseG.teacher_service.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository teacherRepository;
 
 
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
 
 
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }
 
 
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
 
 
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("teacher tidak ditemukan dengan id " + id));
        teacher.setname(teacherDetails.getname());
        teacher.setaddress(teacherDetails.getaddress());
        teacher.setstatus(teacherDetails.getstatus());
        return teacherRepository.save(teacher);
    }
 
 
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("teacher tidak ditemukan dengan id " + id));
        teacherRepository.delete(teacher);
    }

}
