package com.utscaseG.teacher_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "teacher")

public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
 
    private String name;
    private String address;
    private String status;
 
 
    // Constructor tanpa parameter
    public Teacher() {}
 
 
    // Constructor dengan parameter
    public Teacher(String name, String address, String status) {
        this.name = name;
        this.address = address;
        this.address = status;
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
 
    public String getaddress() {
     return address;
     }
 
 
     public void setaddress(String address) {
         this.address = address;
     }
    public String getstatus() {
     return status;
     }
 
 
     public void setstatus(String status) {
         this.status = status;
     }

}
