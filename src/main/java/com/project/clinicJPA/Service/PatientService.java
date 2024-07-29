package com.project.clinicJPA.Service;

import com.project.clinicJPA.Entity.Patient;
import com.project.clinicJPA.Repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    private PatientRepo patientRepo;
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    public Patient findById(long id) {
        return patientRepo.findById(id).get();
    }
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }
    public Patient update(Patient patient) {
        return patientRepo.save(patient);
    }
    public Patient insert(Patient patient) {
        return patientRepo.save(patient);
    }
    public void deleteById(long id) {
        patientRepo.deleteById(id);
    }
}
