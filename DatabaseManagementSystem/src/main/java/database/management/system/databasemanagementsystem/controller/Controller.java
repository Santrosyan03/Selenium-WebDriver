package database.management.system.databasemanagementsystem.controller;

import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class Controller {

    private final ServiceImpl doctorService;

    @Autowired
    public Controller(ServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping ("/getDoctor")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor newDoctor) {
        return doctorService.addDoctor(newDoctor);
    }
}
