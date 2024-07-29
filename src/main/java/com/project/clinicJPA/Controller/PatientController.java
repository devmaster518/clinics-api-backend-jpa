package com.project.clinicJPA.Controller;

import com.project.clinicJPA.Entity.Patient;
import com.project.clinicJPA.Service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("patient")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/list")
    public String ListPatient(Model model) {
        List<Patient>thePatients = patientService.findAll();
        model.addAttribute("patient", thePatients);
        return "patients/list-patient";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Patient thePatient = new Patient();
        theModel.addAttribute("patient", thePatient);
        return "patients/patient-form";
    }
    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient thePatient) {
        patientService.insert(thePatient);
        return "redirect:/patient/list";
    }
    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("patientId") long theId, Model theModel) {
        Patient thePatient = patientService.findById(theId);
        theModel.addAttribute("patient", thePatient);
        return "patients/patient-form";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("patientId") long theId) {
        patientService.deleteById(theId);
        return "redirect:/patient/list";
    }
}
