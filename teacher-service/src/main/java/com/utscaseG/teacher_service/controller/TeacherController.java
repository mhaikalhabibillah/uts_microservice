package com.utscaseG.teacher_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utscaseG.teacher_service.model.Teacher;
import com.utscaseG.teacher_service.service.TeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/teacher")


public class TeacherController {
    
    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;
 
 
    // Endpoint untuk mengambil semua teacher
    @GetMapping
    public List<Teacher> getAllTeacher() {
     log.info("GET /api/teacher accessed");
        return teacherService.getAllTeacher();
    }
 
 
    // Endpoint untuk mengambil Teacher berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
     log.info("GET /api/teacher/{} accessed", id);
        return teacherService.getTeacherById(id)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElse(ResponseEntity.notFound().build());
    }
 
 
    // Endpoint untuk membuat teacher baru
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
     log.info("POST /api/teacher accessed with body: {}", teacher);
        return teacherService.createTeacher(teacher);
    }
 
 
    // Endpoint untuk mengupdate teacher yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
     log.info("PUT /api/teacher/{} accessed with body: {}", id, teacherDetails);
           
     try {
            Teacher updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
            return ResponseEntity.ok(updatedTeacher);
        } catch (RuntimeException e) {
         log.warn("PUT /api/teacher/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
 
 
 //     Endpoint untuk menghapus teacher
     @DeleteMapping("/{id}")
     public ResponseEntity<Map<String, String>> deleteTeacher(@PathVariable Long id) {
         log.info("DELETE /api/teacher/{} accessed", id);
         Map<String, String> response = new HashMap<>();
         try {
             teacherService.deleteTeacher(id);
             response.put("message", "Teacher berhasil dihapus");
             return ResponseEntity.ok(response);
         } catch (RuntimeException e) {
             response.put("message", "Teacher tidak ditemukan dengan id " + id);
             log.warn("DELETE /api/teacher/{} failed: {}", id, e.getMessage());
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
     }
}
