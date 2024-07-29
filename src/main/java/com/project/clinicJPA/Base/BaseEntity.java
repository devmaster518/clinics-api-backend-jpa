package com.project.clinicJPA.Base;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity <ID extends Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    ID id ;

    private String statusCode;
    @org.springframework.data.annotation.CreatedBy
    private String CreatedBy;
    @org.springframework.data.annotation.CreatedDate
    private LocalDateTime CreatedDate;
    @org.springframework.data.annotation.LastModifiedBy
    private String LastModifiedBy;
    @org.springframework.data.annotation.LastModifiedDate
    private LocalDateTime LastModifiedDate;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        LastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        CreatedDate = createdDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
