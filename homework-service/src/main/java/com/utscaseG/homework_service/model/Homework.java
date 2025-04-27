package com.utscaseG.homework_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "homework")

public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
 
    private String matapelajaran;
    private String nilai;
 
 
    // Constructor tanpa parameter
    public Homework() {}
 
 
    // Constructor dengan parameter
    public Homework(String matapelajaran, String nilai) {
        this.matapelajaran = matapelajaran;
        this.nilai = nilai;
    }
 
 
    // Getters dan Setters
    public Long getId() {
        return id;
    }
 
 
    public void setId(Long id) {
        this.id = id;
    }
 
 
    public String getmatapelajaran() {
        return matapelajaran;
    }
 
 
    public void setmatapelajaran(String matapelajaran) {
        this.matapelajaran = matapelajaran;
    }
 
    public String getnilai() {
     return nilai;
     }
 
 
     public void setnilai(String nilai) {
         this.nilai = nilai;
     }

}
