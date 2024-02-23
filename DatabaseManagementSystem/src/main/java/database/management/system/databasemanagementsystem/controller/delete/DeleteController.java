package database.management.system.databasemanagementsystem.controller.delete;

import database.management.system.databasemanagementsystem.exception.NotExistingID;
import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DeleteController {
    private final ServiceImpl service;

    @Autowired
    public DeleteController(ServiceImpl service) {
        this.service = service;
    }

    @DeleteMapping("/delete/{id}")
    public Doctor deleteDoctorByID(@PathVariable Integer id) throws NotExistingID {
        return service.deleteDoctorByID(id);
    }
}
