package com.utscaseG.student_services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student")

public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private String name;
   private String alamat;


   // Constructor tanpa parameter
   public Student() {}


   // Constructor dengan parameter
   public Student(String name, String alamat) {
       this.name = name;
       this.alamat = alamat;
   }


   // Getters dan Setters
   public Long getId() {
       return id;
   }


   public void setId(Long id) {
       this.id = id;
   }


   public String getname() {
       return name;
   }


   public void setname(String name) {
       this.name = name;
   }

   public String getalamat() {
    return alamat;
    }


    public void setalamat(String alamat) {
        this.alamat = alamat;
    }
}
