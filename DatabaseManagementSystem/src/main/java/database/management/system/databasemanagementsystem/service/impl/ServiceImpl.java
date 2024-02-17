package database.management.system.databasemanagementsystem.service.impl;

import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServiceImpl {

    private final DoctorRepository doctorRepository;

    @Autowired
    public ServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }
}
