package database.management.system.databasemanagementsystem.service;

import database.management.system.databasemanagementsystem.model.Doctor;

import java.util.List;

public interface ServiceRep {
    List<Doctor> getAllDoctors();
    Doctor addDoctor(Doctor doctor);
}
