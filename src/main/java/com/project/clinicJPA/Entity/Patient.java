package com.project.clinicJPA.Entity;

import com.project.clinicJPA.Base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient extends BaseEntity<Long> {
    private String name;
    private String gender;
    private String dob;
    private String address;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
