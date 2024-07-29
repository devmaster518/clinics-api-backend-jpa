package com.project.clinicJPA.Entity;

import com.project.clinicJPA.Base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor extends BaseEntity <Long>{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;

//    @OneToMany
//    private Patient patient;
//
//    public Doctor(Patient patient) {
//        this.patient = patient;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
