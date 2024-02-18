package database.management.system.databasemanagementsystem.service.impl;

import database.management.system.databasemanagementsystem.exception.RepeatedIdErrorResponse;
import database.management.system.databasemanagementsystem.model.Doctor;
import database.management.system.databasemanagementsystem.repository.DoctorRepository;
import database.management.system.databasemanagementsystem.service.ServiceRep;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceRep {

    private final DoctorRepository doctorRepository;

    @Autowired
    public ServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) throws RepeatedIdErrorResponse {
        if (doctorRepository.existsById(doctor.getId())) {
            throw new RepeatedIdErrorResponse();
        } else {
            return doctorRepository.save(doctor);
        }
    }

    @Override
    public Doctor deleteDoctorByID(Integer id) {
        Doctor doctorToBeRemoved = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        doctorRepository.deleteById(id);
        return doctorToBeRemoved;
    }

    @Override
    public Doctor updateDoctorByID(Integer id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
            .map(doctor -> {
                doctor.setFullName(updatedDoctor.getFullName());
                doctor.setDateOfBirth(updatedDoctor.getDateOfBirth());
                doctor.setNation(updatedDoctor.getNation());
                doctor.setHospital(updatedDoctor.getHospital());
                doctor.setSpecialization(updatedDoctor.getSpecialization());
                doctor.setFreeDay(updatedDoctor.getFreeDay());
                return doctorRepository.save(doctor);
            })
            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }
}
