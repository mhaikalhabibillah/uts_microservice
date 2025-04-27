package com.utscaseG.student_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utscaseG.student_services.model.Student;
import com.utscaseG.student_services.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/student")

public class StudentController {
    
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

   @Autowired
   private StudentService studentService;


   // Endpoint untuk mengambil semua student
   @GetMapping
   public List<Student> getAllStudent() {
    log.info("GET /api/student accessed");
       return studentService.getAllStudent();
   }


   // Endpoint untuk mengambil Student berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    log.info("GET /api/student/{} accessed", id);
       return studentService.getStudentById(id)
               .map(student -> ResponseEntity.ok().body(student))
               .orElse(ResponseEntity.notFound().build());
   }


   // Endpoint untuk membuat student baru
   @PostMapping
   public Student createStudent(@RequestBody Student student) {
    log.info("POST /api/student accessed with body: {}", student);
       return studentService.createStudent(student);
   }


   // Endpoint untuk mengupdate student yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
    log.info("PUT /api/student/{} accessed with body: {}", id, studentDetails);
          
    try {
           Student updatedStudent = studentService.updateStudent(id, studentDetails);
           return ResponseEntity.ok(updatedStudent);
       } catch (RuntimeException e) {
        log.warn("PUT /api/student/{} failed: {}", id, e.getMessage());
           return ResponseEntity.notFound().build();
       }
   }


//     Endpoint untuk menghapus student
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Long id) {
        log.info("DELETE /api/student/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            studentService.deleteStudent(id);
            response.put("message", "Student berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Student tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/student/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
