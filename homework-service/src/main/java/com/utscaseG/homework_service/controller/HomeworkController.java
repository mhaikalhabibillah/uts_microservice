package com.utscaseG.homework_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.utscaseG.homework_service.model.Homework;
import com.utscaseG.homework_service.service.HomeworkService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/homework")

public class HomeworkController {
    
    private static final Logger log = LoggerFactory.getLogger(HomeworkController.class);

    @Autowired
    private HomeworkService homeworkService;
 
 
    // Endpoint untuk mengambil semua homework
    @GetMapping
    public List<Homework> getAllHomework() {
     log.info("GET /api/homework accessed");
        return homeworkService.getAllHomework();
    }
 
 
    // Endpoint untuk mengambil Homework berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Homework> getHomeworkById(@PathVariable Long id) {
     log.info("GET /api/homework/{} accessed", id);
        return homeworkService.getHomeworkById(id)
                .map(homework -> ResponseEntity.ok().body(homework))
                .orElse(ResponseEntity.notFound().build());
    }
 
 
    // Endpoint untuk membuat homework baru
    @PostMapping
    public Homework createHomework(@RequestBody Homework homework) {
     log.info("POST /api/homework accessed with body: {}", homework);
        return homeworkService.createHomework(homework);
    }
 
 
    // Endpoint untuk mengupdate homework yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Homework> updateHomework(@PathVariable Long id, @RequestBody Homework homeworkDetails) {
     log.info("PUT /api/homework/{} accessed with body: {}", id, homeworkDetails);
           
     try {
            Homework updatedHomework = homeworkService.updateHomework(id, homeworkDetails);
            return ResponseEntity.ok(updatedHomework);
        } catch (RuntimeException e) {
         log.warn("PUT /api/homework/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
 
 
 //     Endpoint untuk menghapus homework
     @DeleteMapping("/{id}")
     public ResponseEntity<Map<String, String>> deleteHomework(@PathVariable Long id) {
         log.info("DELETE /api/homework/{} accessed", id);
         Map<String, String> response = new HashMap<>();
         try {
             homeworkService.deleteHomework(id);
             response.put("message", "Homework berhasil dihapus");
             return ResponseEntity.ok(response);
         } catch (RuntimeException e) {
             response.put("message", "Homework tidak ditemukan dengan id " + id);
             log.warn("DELETE /api/homework/{} failed: {}", id, e.getMessage());
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
     }
}
