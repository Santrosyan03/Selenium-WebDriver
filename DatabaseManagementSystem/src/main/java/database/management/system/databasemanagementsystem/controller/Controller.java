package database.management.system.databasemanagementsystem.controller;

import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class Controller {
    private final ServiceImpl service;

    @Autowired
    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor newDoctor) {
        return service.addDoctor(newDoctor);
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @DeleteMapping("/delete/{id}")
    public Doctor deleteDoctorByID(@PathVariable Integer id) {
        return service.deleteDoctorByID(id);
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor updatedDoctor) {
        return service.updateDoctorByID(id, updatedDoctor);
    }
}
