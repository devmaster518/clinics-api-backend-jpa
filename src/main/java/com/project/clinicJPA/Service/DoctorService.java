package com.project.clinicJPA.Service;

import com.project.clinicJPA.Entity.Doctor;
import com.project.clinicJPA.Repository.DoctorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }
    public Doctor findById(long id) {
        return doctorRepo.findById(id).get();
    }
    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }
    public void update(Doctor doctor) {
        doctorRepo.save(doctor);
    }
    public void insert(Doctor doctor) {
        doctorRepo.save(doctor);
    }
    public void deleteById(long id) {
        doctorRepo.deleteById(id);
    }
}
