package database.management.system.databasemanagementsystem.controller.get;

import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class GetController {
    private final ServiceImpl service;

    @Autowired
    public GetController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/get/{id}")
    public Doctor getDoctorByID(@PathVariable Integer id) {
        return service.getDoctorByID(id);
    }
}
