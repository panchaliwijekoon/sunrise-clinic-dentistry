package com.sunrise.dental.model;
import jakarta.persistence.*;
@Entity
@Table(name = "patients")

public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String phone;
    private String email;
    private String address;

    public patient() {}

    public Long  getId() { return id;}
    public void setId(Long id) { this.id = id;}
    public String getName() { return Name;}
    public void setName(String name) { this.Name = name;}
    public String getPhone() { return phone;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public String getAddress() { return address;}
    public void setAddress(String address) { this.address = address;}

}
