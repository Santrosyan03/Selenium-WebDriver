package database.management.system.databasemanagementsystem.service;

import database.management.system.databasemanagementsystem.exception.NotExistingID;
import database.management.system.databasemanagementsystem.exception.RepeatedIdErrorResponse;
import database.management.system.databasemanagementsystem.model.Doctor;

import java.util.List;

public interface ServiceRep {
    List<Doctor> getAllDoctors();
    Doctor addDoctor(Doctor doctor) throws RepeatedIdErrorResponse;
    Doctor deleteDoctorByID(Integer id) throws NotExistingID;
    Doctor updateDoctorByID(Integer id, Doctor doctor) throws NotExistingID;
    Doctor getDoctorByID(Integer id) throws NotExistingID;
}
