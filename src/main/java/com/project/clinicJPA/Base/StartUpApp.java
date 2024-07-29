package com.project.clinicJPA.Base;

import com.project.clinicJPA.Entity.Doctor;
import com.project.clinicJPA.Entity.Patient;
import com.project.clinicJPA.Service.DoctorService;
import com.project.clinicJPA.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpApp implements CommandLineRunner {


    private DoctorService doctorService;

    private PatientService patientService;

    @Autowired
    public StartUpApp(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(doctorService.findAll().isEmpty()) {
            Doctor doctor1 = new Doctor();
            doctor1.setFirstName("sam");
            doctor1.setLastName("medo");
            doctor1.setEmail("sammedo@gmail.com");
            doctorService.insert(doctor1);
            Doctor doctor2 = new Doctor();
            doctor2.setFirstName("ahmed");
            doctor2.setLastName("hamada");
            doctor2.setEmail("medo@gmail.com");
            doctorService.insert(doctor2);
        }
        if(patientService.findAll().isEmpty()) {
            Patient patient1 = new Patient();
            patient1.setName("mohamed");
            patient1.setAddress("12 madee st");
            patient1.setDob("septazole");
            patientService.insert(patient1);
            Patient patient2 = new Patient();
            patient2.setName("taher");
            patient2.setAddress("24 normady st");
            patient2.setDob("panadole");
            patientService.insert(patient2);
        }

    }
}

