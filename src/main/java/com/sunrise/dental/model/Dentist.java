package com.sunrise.dental.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dentists")

public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;
    private String Specialization;
    private String email;
    private String phone;

    public Dentist() {}
    public long getId() {return id;}
    public void setId(long id) {this.id= id;}
    public String getName() {return Name;}
    public void setName(String name) {this.Name = name;}
    public String getSpecialization() {return Specialization;}
    public void setSpecialization(String specialization) {this.Specialization = specialization;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}



}
