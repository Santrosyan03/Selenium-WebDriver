package database.management.system.databasemanagementsystem.controller.put;

import database.management.system.databasemanagementsystem.exception.NotExistingID;
import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class PutController {
    private final ServiceImpl service;

    @Autowired
    public PutController(ServiceImpl service) {
        this.service = service;
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor updatedDoctor) throws NotExistingID {
        return service.updateDoctorByID(id, updatedDoctor);
    }

}
