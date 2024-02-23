package database.management.system.databasemanagementsystem.controller.post;

import database.management.system.databasemanagementsystem.exception.RepeatedIdErrorResponse;
import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class PostController {
    private final ServiceImpl service;

    @Autowired
    public PostController(ServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor newDoctor) throws RepeatedIdErrorResponse {
        return service.addDoctor(newDoctor);
    }
}
