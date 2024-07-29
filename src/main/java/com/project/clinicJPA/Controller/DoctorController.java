package com.project.clinicJPA.Controller;

import com.project.clinicJPA.Entity.Doctor;
import com.project.clinicJPA.Service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("doctor")
public class DoctorController {
    private DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping("/list")
    public String ListDoctor(Model model) {
        List<Doctor>thedoctors = doctorService.findAll();
        model.addAttribute("doctors", thedoctors);
        return "doctors/list-doctor";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Doctor theDoctor = new Doctor();
        theModel.addAttribute("doctor", theDoctor);
        return "doctors/doctor-form";
    }

    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor) {
        doctorService.insert(theDoctor);
        return "redirect:/doctor/list";
    }
    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("doctorId") long theId, Model theModel) {
        Doctor theDoctor = doctorService.findById(theId);
        theModel.addAttribute("doctor", theDoctor);
        return "doctors/doctor-form";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("doctorId") long theId) {
        doctorService.deleteById(theId);
        return "redirect:/doctor/list";
    }
//    @GetMapping("/access-denied")
//    public String showAccessDenied() {
//
//        return "access-denied";
//    }
}
