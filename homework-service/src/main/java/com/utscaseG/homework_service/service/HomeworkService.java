package com.utscaseG.homework_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utscaseG.homework_service.model.Homework;
import com.utscaseG.homework_service.repository.HomeworkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    @Autowired
   private HomeworkRepository homeworkRepository;


   public List<Homework> getAllHomework() {
       return homeworkRepository.findAll();
   }


   public Optional<Homework> getHomeworkById(Long id) {
       return homeworkRepository.findById(id);
   }


   public Homework createHomework(Homework homework) {
       return homeworkRepository.save(homework);
   }


   public Homework updateHomework(Long id, Homework homeworkDetails) {
       Homework homework = homeworkRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("homework tidak ditemukan dengan id " + id));
       homework.setmatapelajaran(homeworkDetails.getmatapelajaran());
       homework.setnilai(homeworkDetails.getnilai());
       return homeworkRepository.save(homework);
   }


   public void deleteHomework(Long id) {
       Homework homework = homeworkRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("homework tidak ditemukan dengan id " + id));
       homeworkRepository.delete(homework);
   }
    
}
